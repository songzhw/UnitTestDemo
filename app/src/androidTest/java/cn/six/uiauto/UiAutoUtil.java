package cn.six.uiauto;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

public class UiAutoUtil {
        public static void openMyApp(UiDevice device) throws UiObjectNotFoundException {
            device.pressHome();  // device.pressMenu()
            UiObject apps = device.findObject( new UiSelector().description("Apps"));
            apps.clickAndWaitForNewWindow();
            UiObject myApp = device.findObject(new UiSelector().text("AndroidAutoTest"));
            myApp.clickAndWaitForNewWindow();
        }
    }