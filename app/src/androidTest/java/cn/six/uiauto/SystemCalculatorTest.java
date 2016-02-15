package cn.six.uiauto;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by songzhw on 2016/2/15
 */
@RunWith(AndroidJUnit4.class)
public class SystemCalculatorTest {

    UiDevice device;

    @Before
    public void setUp(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testCalculator() throws Exception {
        device.pressHome();
        UiObject calcuApp = device.findObject( new UiSelector().text("Calculator"));
        calcuApp.clickAndWaitForNewWindow();
    }
}
