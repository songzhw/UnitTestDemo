package cn.six.powermock.two;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import cn.six.powermock.TaskUtils;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class UserUtilsTest {
    @Mock
    User03 user;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void call() throws Exception {
        UserUtils.call(user);
        verify(user).call();
    }


}