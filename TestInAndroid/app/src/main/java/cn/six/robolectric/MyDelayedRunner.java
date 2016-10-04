package cn.six.robolectric;

import android.os.Handler;

public class MyDelayedRunner {
    private boolean executed = false;

    public void execute() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                executed = true;
            }
        }, 1000);
    }

    public boolean isExecuted() {
        return executed;
    }
}
