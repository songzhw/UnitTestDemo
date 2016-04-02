package ca.six.test.net2;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * unify the AsyncTask among all the versions
 */
public abstract class AsyncTaskEx<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int KEEP_ALIVE = 10;

    private static final int MESSAGE_POST_RESULT = 0x1;
    private static final int MESSAGE_POST_PROGRESS = 0x2;
    private static final int MESSAGE_POST_CANCEL = 0x3;

    private volatile Status mStatus = Status.PENDING;

    public enum Status {
        PENDING, RUNNING, FINISHED,
    }

    private static final BlockingQueue<Runnable> sWorkQueue = new LinkedBlockingQueue<>(10);

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
        }
    };

    private static final ThreadPoolExecutor sExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
            KEEP_ALIVE, TimeUnit.SECONDS, sWorkQueue, sThreadFactory);

    private static final InternalHandler sHandler = new InternalHandler();
    private final WorkerRunnable<Params, Result> mWorker;
    private final FutureTask<Result> mFuture;


    public AsyncTaskEx() {
        mWorker = new WorkerRunnable<Params, Result>() {
            public Result call() throws Exception {
                Process.setThreadPriority(Process.THREAD_PRIORITY_FOREGROUND);
                return doInBackground(mParams);
            }
        };

        mFuture = new FutureTask<Result>(mWorker) {
            @SuppressWarnings("unchecked")
            @Override
            protected void done() {
                Message message;
                Result result = null;

                try {
                    result = get();
                } catch (InterruptedException e) {
                    Log.w(this.getClass().getSimpleName(), e.getMessage());
                } catch (ExecutionException e) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e.getCause());
                } catch (CancellationException e) {
                    message = sHandler.obtainMessage(MESSAGE_POST_CANCEL, new AsyncTaskResult<>(AsyncTaskEx.this, (Result[]) null));
                    message.sendToTarget();
                    return;
                } catch (Throwable t) {
                    throw new RuntimeException("An error occured while executing " + "doInBackground()", t);
                }

                message = sHandler.obtainMessage(MESSAGE_POST_RESULT, new AsyncTaskResult<>(AsyncTaskEx.this, result));
                message.sendToTarget();
            }
        };
    }

    private static class InternalHandler extends Handler {
        @SuppressWarnings({"rawtypes", "unchecked"})
        @Override
        public void handleMessage(Message msg) {
            AsyncTaskResult result = (AsyncTaskResult) msg.obj;
            switch (msg.what) {
                case MESSAGE_POST_RESULT:
                    // There is only one result
                    result.mTask.finish(result.mData[0]);
                    break;
                case MESSAGE_POST_PROGRESS:
                    result.mTask.onProgressUpdate(result.mData);
                    break;
                case MESSAGE_POST_CANCEL:
                    result.mTask.onCancelled();
                    break;
            }
        }
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return mFuture.get();
    }

    public final Status getStatus() {
        return mStatus;
    }

    protected abstract Result doInBackground(Params... params);

    protected void onPreExecute() {
    }

    protected void onPostExecute(Result result) {
    }

    protected void onProgressUpdate(Progress... values) {
    }

    protected void onCancelled() {
    }

    public final boolean isCancelled() {
        return mFuture.isCancelled();
    }

    public final boolean cancel(boolean mayInterruptIfRunning) {
        return mFuture.cancel(mayInterruptIfRunning);
    }

    @SuppressWarnings("incomplete-switch")
    public final AsyncTaskEx<Params, Progress, Result> execute(Params... params) {
        if (mStatus != Status.PENDING) {
            switch (mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task:" + " the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task:" + " the task has already been executed "
                            + "(a task can be executed only once)");
            }
        }

        mStatus = Status.RUNNING;

        onPreExecute();

        mWorker.mParams = params;
        sExecutor.execute(mFuture);
        return this;
    }

    protected final void publishProgress(Progress... values) {
        sHandler.obtainMessage(MESSAGE_POST_PROGRESS, new AsyncTaskResult<>(this, values)).sendToTarget();
    }

    private void finish(Result result) {
        if (isCancelled()) {
            result = null;
        }
        onPostExecute(result);
        mStatus = Status.FINISHED;
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;
    }

    private static class AsyncTaskResult<Data> {
        @SuppressWarnings("rawtypes")
        final AsyncTaskEx mTask;
        final Data[] mData;

        AsyncTaskResult(@SuppressWarnings("rawtypes") AsyncTaskEx task, Data... data) {
            mTask = task;
            mData = data;
        }
    }
}
