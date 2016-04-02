package ca.six.test.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import ca.six.test.R;
import ca.six.test.core.Debug;
import ca.six.test.model.User;
import ca.six.test.net.HttpEngine;
import ca.six.test.net.MockApiRepo;
import ca.six.test.net2.BaseRequest;
import ca.six.test.net2.IRespListener;

public class GUserActivity3 extends AppCompatActivity implements IRespListener {
    public static boolean isFinishHttp = false;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFinishHttp = false;
                startRequest();
            }
        });
    }


    private void startRequest() {
        System.out.println("szw start to http");
        BaseRequest req = new BaseRequest();
        String url = "https://api.github.com/users/songzhw";
        req.startRequest(url, this);
    }


    @Override
    public void onResponsed(String resp) {
        final User user = new Gson().fromJson(resp, User.class);
        isFinishHttp = true;
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.setText(user.name);
            }
        });

    }
}
