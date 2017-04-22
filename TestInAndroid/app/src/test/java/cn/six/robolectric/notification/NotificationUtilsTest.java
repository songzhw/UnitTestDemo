package cn.six.robolectric.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.shadows.ShadowNotificationManager;

import cn.six.robolectric.BaseRoboTestCase;
import static junit.framework.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

public class NotificationUtilsTest extends BaseRoboTestCase {

    private ShadowNotificationManager shadow;

    @Before
    public void setUp() throws Exception {
        NotificationManager mgr = (NotificationManager)app.getSystemService(Context.NOTIFICATION_SERVICE);
        shadow = shadowOf(mgr);
    }

    @Test
    public void call_sendNotification(){
        assertEquals(shadow.size(), 0);

        NotificationUtils utils = new NotificationUtils();
        utils.showNotification(app);
        assertEquals(shadow.size(), 1);
    }

    @Test
    public void call_actionAllSend(){
        Notification notification = getNotification();
        assertEquals(notification.actions.length, 3);
    }

    private Notification getNotification() {NotificationUtils utils = new NotificationUtils();
        utils.showNotification(app);
        return shadow.getAllNotifications().get(0);
    }


    @Test
    public void call_action1GoesB(){
        Notification notification = getNotification();
        // 说是有API 19才有的方法。 但这是测试方法， 所以没事的
        PendingIntent pendingIntent = notification.actions[0].actionIntent;
        Intent action1Intent = shadowOf(pendingIntent).getSavedIntent();
        String nextClasName = action1Intent.getComponent().getClassName();
        assertEquals(nextClasName, Notification_B.class.getName());

        String value = action1Intent.getStringExtra("key");
        assertEquals(value, "This is B");
    }


    @Test
    public void call_contentIntentGoesToE() {
        Notification notification = getNotification();
        PendingIntent pendingIntent = notification.contentIntent;
        Intent contentIntent = shadowOf(pendingIntent).getSavedIntent();
        String nextClasName = contentIntent.getComponent().getClassName();
        assertEquals(nextClasName, Notification_E.class.getName());

        String value = contentIntent.getStringExtra("key");
        assertEquals(value, "This is E");
    }



}