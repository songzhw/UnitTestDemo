package cn.six.junit;

public class UserManager {
    public boolean isLogin() {
        return false;
    }

    public void login(UserType userType, final LoginCallback callback) {
        callback.onSucc();
    }
}