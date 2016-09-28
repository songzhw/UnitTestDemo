package cn.six.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by songzhw on 2016-09-27
 */

public class PushService extends Service {
    public String pushID;
    public BarManager bar;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onMessageReceived(String id, Bundle data){
        pushID = id;
        String value = data.getString("testKey");
        FooManager.getInstance().receivedMsg(data);
        if(bar == null){
            bar = BarManager.getInstance();
        }
        bar.receivedMsg(data);
    }
}
