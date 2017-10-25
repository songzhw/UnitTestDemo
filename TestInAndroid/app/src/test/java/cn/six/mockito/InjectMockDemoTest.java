package cn.six.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class InjectMockDemoTest {
    @InjectMocks
    public String name;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(name.toLowerCase()).thenReturn("SZW");
    }

    @Test
    public void testModify(){
        InjectMockDemo obj = new InjectMockDemo();
        System.out.println(obj.modify());
    }
}

