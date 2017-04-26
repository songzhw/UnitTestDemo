package cn.six.junit.uithread;

import android.os.Looper;

import cn.six.junit.LoginCallback;
import cn.six.junit.UserManager;
import cn.six.junit.UserType;

public class LoginPresenter2 {
    private UserManager2 mgr;
    public Looper looper;

    public LoginPresenter2(UserManager2 mgr) {
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

}

/*

public class LoginPresenterTest extends BaseRoboTestCase{
    @Mock UserManager mgr;
    @Captor ArgumentCaptor<LoginCallback> captor;

    @Before public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(mgr.isLogin()).thenReturn(false);
    }

    @Test public void testLogin(){
        LoginPresenter presenter = new LoginPresenter(mgr);
        presenter.login();

        verify(mgr).login(eq(UserType.LEGAL), captor.capture());
        captor.getValue().onSucc();

        System.out.println("szw 1 "+presenter.getLooper());
        System.out.println("szw 2 "+Looper.getMainLooper());
        assertNotEquals(Looper.getMainLooper(), presenter.getLooper());
    }

}

But our test case failed. The two looper equals.
That's because Robolectric is running on the UI thread?
 */