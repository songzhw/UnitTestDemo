package cn.six.robolectric;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DemoReceiver extends BroadcastReceiver {
    public int value = -1;

    @Override
    public void onReceive(Context context, Intent intent) {
        value = 10;
    }
}