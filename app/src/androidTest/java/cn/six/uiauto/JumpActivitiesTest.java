package cn.six.uiauto;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.Configurator;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.uiauto.core.BlackTest;

/**
 * Created by songzhw on 2016/2/18
 */
@RunWith(AndroidJUnit4.class)
public class JumpActivitiesTest extends BlackTest {

    @Test
    public void testJump() throws UiObjectNotFoundException {
        UiAutoUtil.openMyApp(device);

        UiObject et = device.findObject(new UiSelector().className("android.widget.EditText"));
        et.setText("Tomorrow");

        UiObject btnJump = device.findObject(new UiSelector().text("Open activity and change text"));
        btnJump.clickAndWaitForNewWindow();

        UiObject tv2 = device.findObject(new UiSelector().resourceId("cn.six.aut:id/tv_jumpto_display"));
        Assert.assertEquals("Tomorrow", tv2.getText());
    }

}
