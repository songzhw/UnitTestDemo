package cn.six.service;

import android.os.Bundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import cn.six.aut.BuildConfig;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by songzhw on 2016-09-27
 */
@RunWith(RobolectricTestRunner.class)  // 不用这个， 就在buildActivity时会错的
@Config(constants = BuildConfig.class) // 修复说找不到AndroidManifest的warning
public class PushServiceTest {
    public PushService service;
    private Bundle data;

    @Before
    public void setUp(){
        data = mock(Bundle.class);
        data.putString("testKey", "robo-ing");

        service = Robolectric.setupService(PushService.class);
    }

    @Test
    public void testReceivedMessage_ID(){
        service.onMessageReceived("23", data);
        assertEquals("23", service.pushID);
    }

    @Test
    public void testReceivedMessage_Bundle(){
        service.onMessageReceived("23", data);
        verify(data).getString("testKey");
    }

    // PowerMock does not support working with Robolectric together
    // that's why I separate the BarManager from service
    // so we can make sure the singleton in our way
    @Test
    public void testReceivedMessage_Singleton(){
        BarManager mgr = mock(BarManager.class);
        service.bar = mgr;
        service.onMessageReceived("23", data);
        verify(service.bar).receivedMsg(data);
    }

    /*
        // error. Mockito does not support mock the static method
        FooManager mgr = mock(FooManager.class);
        when(FooManager.getInstance()).thenReturn(mgr);
        verify(mgr).receivedMsg(data);
    **/

}
