package cn.six.http;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by songzhw on 2016-10-26
 */

public class HttpEngine {

    public void request(final String url, final Callback callback)  {

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();

                client.newCall(request)
                        .enqueue(callback);
            }
        }).start();

    }

}
