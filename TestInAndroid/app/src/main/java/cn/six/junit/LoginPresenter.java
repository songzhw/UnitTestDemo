package cn.six.junit;

public class LoginPresenter {
    private UserManager mgr;

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
        }
    };
}