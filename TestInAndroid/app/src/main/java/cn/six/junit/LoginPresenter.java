package cn.six.junit;

import android.os.Looper;

public class LoginPresenter {
    private UserManager mgr;
    public Looper looper;

    public LoginPresenter(UserManager mgr) {
        this.mgr = mgr;
    }

    public void login() {
        if (!mgr.isLogin()) {
            mgr.login(UserType.LEGAL, callback);
        }
    }

    private LoginCallback callback = new LoginCallback(){
        @Override
        public void onSucc() {
            System.out.println("szw login succ");
            looper = Looper.myLooper();
        }
    };

    public Looper getLooper() {
        return looper;
    }
}