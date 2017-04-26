package cn.six.junit;

public class UserManager {
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