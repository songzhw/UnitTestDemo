package cn.six.http;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;

import cn.six.robolectric.BaseRoboTestCase;
import okhttp3.Callback;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by songzhw on 2016-10-26
 */
public class HttpDemoTest extends BaseRoboTestCase {
    @Captor
    private ArgumentCaptor<Callback> captor;
    @Mock
    HttpEngine http;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void onClick() throws Exception {
        HttpDemo actv = Robolectric.setupActivity(HttpDemo.class);
        actv.setHttpEngine(http);
        actv.btn.performClick();

        verify(http).request(eq(HttpDemo.url1), captor.capture());

        // okhttp3.Request is a "final" class. Cannot be mocked
        // okhttp3.Response is a "final" class. Cannot be mocked
        Request req = new Request.Builder().url(HttpDemo.url1).build();
        ResponseBody body = ResponseBody.create(null, "abc");
        Response resp = new Response.Builder().body(body)
                .request(req)
                .protocol(Protocol.HTTP_1_1)
                .code(400)
                .build();

        captor.getValue().onResponse(null, resp);

        assertEquals("abc", actv.btn.getText());
    }
}