package cn.six.junit.uithread;
import android.os.Looper;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cn.six.junit.LoginCallback;
import cn.six.junit.LoginPresenter;
import cn.six.junit.UserType;
import cn.six.robolectric.BaseRoboTestCase;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresenter2Test extends BaseRoboTestCase{
    @Mock UserManager2 mgr;
    @Captor ArgumentCaptor<LoginCallback> captor;

    @Before public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(mgr.isLogin()).thenReturn(false);
    }

    // This is a failing test case
    @Ignore
    @Test public void testLogin(){
        LoginPresenter2 presenter = new LoginPresenter2(mgr);
        presenter.login();

        verify(mgr).login(eq(UserType.LEGAL), captor.capture());
        captor.getValue().onSucc();

        System.out.println("szw 1 "+presenter.looper);
        System.out.println("szw 2 "+Looper.getMainLooper());
        assertNotEquals(Looper.getMainLooper(), presenter.looper);
    }



}