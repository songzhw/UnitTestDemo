package cn.six.uiauto;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by songzhw on 2016/2/16
 */
public class SystemCalculatorTest4 {

    UiDevice device;

    @Before
    public void setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testCalculator4() throws Exception {
        device.pressHome();
        UiObject2 calcuApp = device.findObject( By.text("Calculator"));
        calcuApp.click();
    }
}
