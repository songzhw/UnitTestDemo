package cn.six.robolectric.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.shadows.ShadowNotificationManager;

import ca.six.aut.robolectric.BaseRoboTestCase;
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



}