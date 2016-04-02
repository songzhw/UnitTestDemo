package ca.six.test.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import ca.six.test.R;
import ca.six.test.model.User;
import ca.six.test.net2.BaseRequest;
import ca.six.test.net2.IRespListener;

public class GUserActivity3 extends AppCompatActivity implements IRespListener {
    private TextView tv;
    public BaseRequest req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        req = new BaseRequest();

        tv = (TextView) findViewById(R.id.tv_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRequest();
            }
        });
    }


    private void startRequest() {
        System.out.println("szw start to http");

        String url = "https://api.github.com/users/songzhw";
        req.startRequest(url, this);
    }


    @Override
    public void onResponsed(String resp) {
        final User user = new Gson().fromJson(resp, User.class);
        tv.setText(user.name);
    }
}
