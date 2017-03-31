package cn.six.robolectric;

import android.app.Activity;
import android.os.Bundle;

public class LifeCycleActivity extends Activity {
    public String stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stage = "onCreate";
    }

    @Override
    protected void onStart() {
        super.onStart();
        stage = "onStart";
    }

    @Override
    protected void onResume() {
        super.onResume();
        stage = "onResume";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stage = "onDestroy";
    }
}