package cn.six.uiauto;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by songzhw on 2016/2/15
 */
@RunWith(AndroidJUnit4.class)
public class SystemCalculatorTest3 {

    UiDevice device;

    @Before
    public void setUp(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testCalculator3() throws Exception {
        device.pressHome();
        UiObject calcuApp = device.findObject( new UiSelector().text("Calculator"));
        calcuApp.clickAndWaitForNewWindow();

        UiObject seven = device.findObject( new UiSelector().text("7"));
        seven.click();
        UiObject plus = device.findObject( new UiSelector().text("+"));
        plus.click();
        UiObject one = device.findObject( new UiSelector().text("1"));
        one.click();
        UiObject equal = device.findObject( new UiSelector().text("="));
        equal.click();

        // Error : android.support.test.uiautomator.UiObjectNotFoundException: UiSelector[FOCUSED=true]
//        UiObject result = device.findObject(new UiSelector().focused(true));

        UiObject result = device.findObject(new UiSelector().resourceId("com.android.calculator2:id/result"));
        Assert.assertNotNull(result);
    }
}

/*

Note :

    If you are testing your own app, then you will have no such embarrassment in the result view,
    you can call "new UiSelector().resourceId("my.package.etResult")"
    , or " . className()"

 */