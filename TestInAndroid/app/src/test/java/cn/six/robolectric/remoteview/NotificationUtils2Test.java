package cn.six.robolectric.remoteview;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.internal.ShadowExtractor;
import org.robolectric.shadows.ShadowNotificationManager;

import cn.six.espresso.aut.BuildConfig;
import cn.six.espresso.aut.R;
import cn.six.robolectric.notification.Notification_B;

import static junit.framework.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP,
        shadows = {ShadowRemoteViews.class})
public class NotificationUtils2Test  {
    private ShadowNotificationManager shadow;
    private Context app = RuntimeEnvironment.application;

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

        ShadowRemoteViews shadow = (ShadowRemoteViews)ShadowExtractor.extract(remoteViews);

        PendingIntent pendingIntent = shadow.getActions().get(R.id.btn_notification_two);
        Intent action1Intent = shadowOf(pendingIntent).getSavedIntent();
        String nextClasName = action1Intent.getComponent().getClassName();
        assertEquals(nextClasName, Notification_B.class.getName());

        String value = action1Intent.getStringExtra("key");
        assertEquals(value, "This is B");

    }

}

