package cn.six.espresso.async2;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import cn.six.aut.R;

/**
 * @author songzhw
 * @date 2015/9/24
 * Copyright 2015 Six. All rights reserved.
 */
public class Sync2Actv extends Activity {
    private IServer server;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        setContentView(R.layout.activity_async_task);
        this.tv = (TextView) findViewById(R.id.tv_async_result);


        setServer(new IServer() {
            @Override
            public String getResult() {
                Random rand = new Random();
                int time = rand.nextInt(5000);
                SystemClock.sleep(time + 2000);
                Log.d("szw", "time = "+time);
//                return "Hello from szw after "+time/1000;
                return "Hello from szw";
            }
        });
    }

    // 测试的类可以更改它
    public void setServer(IServer serv){
        this.server = serv;
    }

    public IServer getServer(){ return server;}

    public void onClickStart(View v){
        new Thread(){
            @Override
            public void run() {
                final String result = server.getResult();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(result);
                    }
                });
            }
        }.start();
    }
}
