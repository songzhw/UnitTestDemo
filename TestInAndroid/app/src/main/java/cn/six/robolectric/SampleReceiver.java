package cn.six.robolectric;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import java.util.Locale;

/**
 * @copyright six.ca
 * Created by Xiaolin on 2016-11-14.
 */

public class SampleReceiver extends BroadcastReceiver {
    public int value = -1;
    private String operatorIso3;

    @Override
    public void onReceive(Context context, Intent intent) {
        value = 10;
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        System.out.println("manager: " + manager);
        System.out.println("iso: " + manager.getNetworkCountryIso());

        operatorIso3 = new Locale("", manager.getNetworkCountryIso()).getISO3Country();
    }
}
