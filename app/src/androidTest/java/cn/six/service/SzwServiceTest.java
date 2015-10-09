package cn.six.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeoutException;

import cn.six.aut.SzwService;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class SzwServiceTest {
    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();

    @Test
    public void testWithBoundService() throws TimeoutException {
        // Create the service Intent.
        Intent serviceIntent =
                new Intent(InstrumentationRegistry.getTargetContext(), SzwService.class);

        // Data can be passed to the service via the Intent.
        serviceIntent.putExtra(SzwService.SEED_KEY, 42L);

        // Bind the service and grab a reference to the binder.
        IBinder binder = mServiceRule.bindService(serviceIntent);

        // Get the reference to the service, or you can call public methods on the binder directly.
        SzwService service = ((SzwService.LocalBinder) binder).getService();

        // Verify that the service is working correctly.
        assertThat(service.getRandomInt(), is(any(Integer.class)));
    }
}
