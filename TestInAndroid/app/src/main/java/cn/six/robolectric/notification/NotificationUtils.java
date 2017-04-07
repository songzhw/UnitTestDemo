package cn.six.robolectric.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import cn.six.aut.R;

// In order to test, this class is not a container of all the staic class
public class NotificationUtils {
    public void showNotification(Context context){
        Intent it1 = new Intent(context, Notification_B.class);
        it1.putExtra("key","This is B");
        PendingIntent pi1 = PendingIntent.getActivity(context, 0, it1, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent it2 = new Intent(context, Notification_C.class);
        it2.putExtra("key","This is C");
        PendingIntent pi2 = PendingIntent.getActivity(context, 0, it2, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent it3 = new Intent(context, Notification_D.class);
        it3.putExtra("key","This is D");
        PendingIntent pi3 = PendingIntent.getActivity(context, 0, it3, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent it4 = new Intent(context, Notification_E.class);
        it4.putExtra("key","This is E");
        PendingIntent pi4 = PendingIntent.getActivity(context, 0, it4, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(context)
            .setContentTitle("Title")
            .setContentText("Good Friday is coming")
            .setSmallIcon(R.drawable.ic_pets)
            .setContentIntent(pi4)
            .setAutoCancel(true)
            .addAction(R.drawable.ic_alarm, "Alarm", pi1)
            .addAction(R.drawable.ic_notifications, "Notify", pi2)
            .addAction(R.drawable.ic_radio_checked, "check", pi3)
            .build();
        NotificationManagerCompat compat = NotificationManagerCompat.from(context);
        compat.notify(23, notification);
    }
}