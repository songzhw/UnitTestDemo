package cn.six.junit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {
    @Mock
    UserManager mgr;
    @Captor
    ArgumentCaptor<LoginCallback> captor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(mgr.isLogin()).thenReturn(false);
    }

    @Test
    public void testLogin(){
        LoginPresenter presenter = new LoginPresenter(mgr);
        presenter.login();

        verify(mgr).login(UserType.LEGAL, captor.capture());//failed
    }

}