package cn.six.robolectric.remoteview;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.widget.RemoteViews;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.shadows.ShadowNotificationManager;

import cn.six.robolectric.BaseRoboTestCase;
import static junit.framework.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

public class NotificationUtils2Test extends BaseRoboTestCase {
    private ShadowNotificationManager shadow;

    @Before
    public void setUp() throws Exception {
        NotificationManager mgr = (NotificationManager)app.getSystemService(Context.NOTIFICATION_SERVICE);
        shadow = shadowOf(mgr);
    }

    private Notification getNotification() {
        NotificationUtils2 utils = new NotificationUtils2();
        utils.showNotification(app);
        return shadow.getAllNotifications().get(0);
    }

    @Test
    public void call_sendNotification() {
        assertEquals(shadow.size(), 0);

        NotificationUtils2 utils = new NotificationUtils2();
        utils.showNotification(app);
        assertEquals(shadow.size(), 1);
    }

    @Test
    public void call_actionClick() {
        Notification notification = getNotification();
        RemoteViews remoteViews = notification.bigContentView;
        System.out.println("szw remoteViews = " + remoteViews);
    }

}

