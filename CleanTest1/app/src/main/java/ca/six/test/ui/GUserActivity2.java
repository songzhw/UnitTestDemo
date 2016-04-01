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

public class GUserActivity2 extends AppCompatActivity {
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
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startRequest();
                    }
                }).start();
            }
        });
    }


    private void startRequest() {
        System.out.println("szw start to http");
        final User songzhw = getUser();
        System.out.println("szw get: " + songzhw);


        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                refreshUI(songzhw);
            }
        });


    }

    public User getUser() {
        try {
            User songzhw = HttpEngine.getInstance().getHttpApi()
                    .getUser("songzhw")
                    .execute()
                    .body();
            return songzhw;
        } catch (Exception e) {
        }
        return null;
    }

    public void refreshUI(User user) {
        isFinishHttp = true;
        tv.setText(user.name);
    }


}
