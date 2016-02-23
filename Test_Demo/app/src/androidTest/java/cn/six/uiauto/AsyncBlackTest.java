package cn.six.uiauto;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import junit.framework.Assert;

import org.junit.Test;

import cn.six.uiauto.core.BlackTest;

/**
 * Created by songzhw on 2016/2/22
 */
public class AsyncBlackTest extends BlackTest {

    @Test
    public void testAsync() throws UiObjectNotFoundException {
        UiAutoUtil.openMyApp(device);

        UiObject btnStart = device.findObject(new UiSelector().text("start"));
        btnStart.click();

//        device.waitForIdle(5000); // default value is 10s
        device.waitForWindowUpdate("cn.six.aut",6000);

        UiObject tv = device.findObject(new UiSelector().resourceId("cn.six.aut:id/tv_async_result"));
        Assert.assertEquals(tv.getText(), "szw ok");
    }

}
