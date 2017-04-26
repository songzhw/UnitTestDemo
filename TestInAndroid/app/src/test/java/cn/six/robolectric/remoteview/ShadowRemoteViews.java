package cn.six.robolectric.remoteview;

import android.app.PendingIntent;
import android.widget.RemoteViews;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import java.util.HashMap;

@Implements(RemoteViews.class)
public class ShadowRemoteViews {
    private HashMap<Integer, PendingIntent> actions = new HashMap<>();

    @Implementation
    public void setOnClickPendingIntent(int viewId, final PendingIntent pendingIntent) {
        actions.put(viewId, pendingIntent);
    }

    public HashMap<Integer, PendingIntent> getActions() {
        return actions;
    }
}