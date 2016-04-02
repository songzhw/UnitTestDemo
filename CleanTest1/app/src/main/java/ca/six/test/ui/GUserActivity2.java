package ca.six.test.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ca.six.test.R;
import ca.six.test.model.User;
import ca.six.test.net.HttpEngine;
import ca.six.test.net.IHttpApi;

public class GUserActivity2 extends AppCompatActivity {
    private TextView tv;
    public IHttpApi httpApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpApi = HttpEngine.getHttpApi();

        tv = (TextView) findViewById(R.id.tv_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        try {
            final User songzhw = httpApi .getUser("songzhw")
                    .execute()
                    .body();

            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    refreshUI(songzhw);
                }
            });

        } catch (Exception e) {
        }
    }

    public void refreshUI(User user) {
        tv.setText(user.name);
    }


}
