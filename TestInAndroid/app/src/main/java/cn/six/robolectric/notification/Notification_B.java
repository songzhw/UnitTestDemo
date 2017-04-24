package cn.six.robolectric.notification;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import cn.six.espresso.aut.R;


public class Notification_B extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_btn);

        TextView tv = (TextView) findViewById(R.id.tv_simple);
        tv.setText("Page BBB || "+getIntent().getStringExtra("key"));
    }

    public void onClickSimpleButton(View v){}
    public void onClickSimpleButton2(View v){}
}
