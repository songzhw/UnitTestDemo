package cn.six.service;

import android.os.Bundle;

/**
 * Created by songzhw on 2016-09-27
 */

public class BarManager {
    private static BarManager instance = new BarManager();

    private BarManager(){}

    public static BarManager getInstance(){
        return instance;
    }

    public void receivedMsg(Bundle data){

    }
}
