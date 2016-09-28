package cn.six.service;

import android.os.Bundle;

/**
 * Created by songzhw on 2016-09-27
 */

public class FooManager {
    private static FooManager instance = new FooManager();

    private FooManager(){}

    public static FooManager getInstance(){
        return instance;
    }

    public void receivedMsg(Bundle data){

    }
}
