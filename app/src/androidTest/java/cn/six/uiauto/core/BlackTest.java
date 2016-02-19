package cn.six.uiauto.core;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;

/**
 * Created by songzhw on 2016/2/19
 */
public class BlackTest {
    protected UiDevice device;

    @Before
    public void setup(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        Configurator config = Configurator.getInstance();
        config.setActionAcknowledgmentTimeout(1000);
        config.setWaitForSelectorTimeout(1000);
        config.setWaitForIdleTimeout(1000);
        config.setKeyInjectionDelay(300);
        config.setScrollAcknowledgmentTimeout(100);
    }

}
