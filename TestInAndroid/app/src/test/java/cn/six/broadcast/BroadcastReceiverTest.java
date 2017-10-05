package cn.six.broadcast;

import android.content.Intent;
import android.content.IntentFilter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import cn.six.aut.BuildConfig;
import cn.six.robolectric.DemoReceiver;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class BroadcastReceiverTest {

    private DemoReceiver receiver;
    private Intent it;

    @Before()
    public void setUp() {
        this.receiver = new DemoReceiver();
        IntentFilter filter = new IntentFilter("ca.six.demo.broadcast");
        ShadowApplication.getInstance().registerReceiver(this.receiver, filter);

        this.it = new Intent("ca.six.demo.broadcast");
        RuntimeEnvironment.application.sendBroadcast(this.it);
    }

    @Test
    public void testRegister() {
        assertTrue(ShadowApplication.getInstance().hasReceiverForIntent(it));
    }

    @Test
    public void testReceive() {
        assertEquals(10, receiver.value);
    }
}