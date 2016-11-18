package cn.six.http;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by songzhw on 2016-10-26
 */

public class FakeHttpEngine extends HttpEngine {

    public void request(final String url, final Callback callback)  {
//        try {
////            Response resp = mock(Response.class);
////            ResponseBody body = mock(ResponseBody.class);
////            when(body.toString()).thenReturn("abc");
////            when(resp.body()).thenReturn(body);
////            ResponseBody body = ResponseBody.create(null, "abc");
////            Response resp;
////            callback.onResponse(null, resp);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
