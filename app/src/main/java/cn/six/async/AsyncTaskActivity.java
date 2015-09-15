package cn.six.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.six.aut.R;

public class AsyncTaskActivity extends Activity implements View.OnClickListener{

    public static boolean isFinished = false;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        findViewById(R.id.btn_async_start).setOnClickListener(this);
        this.tv = (TextView) findViewById(R.id.tv_async_result);
    }

    @Override
    public void onClick(View view) {
        MyAsyncTask task = new MyAsyncTask();
        task.execute();
    }
    private class MyAsyncTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {
            isFinished = false;
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "ok";
        }

        @Override
        protected void onPostExecute(String s) {
            isFinished = true;
            tv.setText("szw "+s);
        }
    }
}
