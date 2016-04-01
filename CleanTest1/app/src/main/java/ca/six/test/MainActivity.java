package ca.six.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ca.six.test.model.User;
import ca.six.test.net.HttpEngine;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            startRequest();
                        } catch (Exception e) {
                            System.out.println("szw error : "+e);
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        });


    }

    private void startRequest() throws Exception {
        System.out.println("szw start to http");
        final User songzhw = HttpEngine.getInstance().getHttpApi()
                .getUser("songzhw")
                .execute()
                .body();
        System.out.println("szw get: " +songzhw);

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.setText(songzhw.name);
            }
        });

    }


}
