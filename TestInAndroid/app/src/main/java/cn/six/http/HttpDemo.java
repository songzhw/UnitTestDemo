package cn.six.http;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by songzhw on 2016-10-26
 *
 * https://api.github.com/users/songzhw
 *
 * https://publicobject.com/helloworld.txt
 *
 */

public class HttpDemo extends Activity implements View.OnClickListener {
    private String url1 = "https://api.github.com/users/songzhw";
    private String url2 = "https://publicobject.com/helloworld.txt";

    private HttpDemo self;
    public Button btn;
    private HttpEngine http;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        self = this;
        setHttpEngine(new HttpEngine());

        btn = new Button(this);
        btn.setText("Http -> ");
        btn.setOnClickListener(this);
        setContentView(btn);
    }

    public void setHttpEngine(HttpEngine http){
        this.http = http;
    }

    @Override
    public void onClick(View v) {
        http.request(url1, new HttpCallback());
    }

    private class HttpCallback implements Callback {
        @Override
        public void onFailure(Call call, final IOException e) {
            self.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    btn.setText(e.toString());
                }
            });

        }

        @Override
        public void onResponse(Call call, final Response response) throws IOException {
            final String str = response.body().string();

            self.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    btn.setText(str);
                }
            });


        }
    }
}
