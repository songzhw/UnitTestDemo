package cn.six.robolectric.remoteview;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;

import cn.six.aut.R;
import cn.six.robolectric.notification.Notification_B;

public class NotificationUtils2 {
    public void showNotification(Context context){
        Intent it1 = new Intent(context, Notification_B.class);
        it1.putExtra("key","This is B");
        PendingIntent pi1 = PendingIntent.getActivity(context, 0, it1, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.view_notification_two);
        remoteViews.setTextViewText(R.id.tv_notification_two, "This is push content");
        remoteViews.setOnClickPendingIntent(R.id.btn_notification_two, pi1);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
            .setContentTitle("Push")
            .setContentText("Push Content")
            .setAutoCancel(true);
        Notification notification = builder.build();
        notification.bigContentView = remoteViews;

        NotificationManagerCompat mgr = NotificationManagerCompat.from(context);
        mgr.notify(100, notification);

    }
}

