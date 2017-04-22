package cn.six.junit;

public class UserManager {
    public boolean isLogin(){
        return false;
    }

    public void login(UserType userType, LoginCallback callback){
        callback.onSucc();
    }
}