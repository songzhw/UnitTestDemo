package cn.six.espresso.first;

import android.app.Activity;
import android.os.Bundle;

import cn.six.espresso.aut.R;


public class OneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }

}
