package cn.six.robolectric;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowTelephonyManager;

import cn.six.espresso.aut.BuildConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

/**
 * @copyright six.ca
 * Created by Xiaolin on 2016-11-14.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SampleReceiverTest {

    private SampleReceiver receiver;
    private Intent intent;
    private Application app;

    @Before
    public void setUp(){
        this.receiver = new SampleReceiver();
        IntentFilter filter = new IntentFilter("ca.six.sample.broadcast");
        ShadowApplication.getInstance().registerReceiver(this.receiver, filter);

    }

    @Test
    public void testRegister(){
        app = RuntimeEnvironment.application;
        TelephonyManager telephonyManager = (TelephonyManager) app.getSystemService(Context.TELEPHONY_SERVICE);
        ShadowTelephonyManager shadowTelManager = shadowOf(telephonyManager);
        shadowTelManager.setNetworkCountryIso("CA"); // getNetworkCountryIso


        this.intent = new Intent("ca.six.sample.broadcast");
        RuntimeEnvironment.application.sendBroadcast(this.intent);




        assertTrue(ShadowApplication.getInstance().hasReceiverForIntent(this.intent));
    }

//    @Test
//    public void testOnReceive(){
//        assertEquals(10, receiver.value);
//    }
}
