package cn.six.junit.uithread;

import cn.six.junit.LoginCallback;
import cn.six.junit.UserType;

public class UserManager2 {
    public boolean isLogin(){
        return false;
    }

    public void login(UserType userType, final LoginCallback callback){
        new Thread(){
            @Override
            public void run() {
                callback.onSucc();
            }
        }.start();
    }
}