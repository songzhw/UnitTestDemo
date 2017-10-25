package cn.six.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


public class InjectMockDemoTest {
    @InjectMocks
    public String name;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testModify(){
        InjectMockDemo obj = new InjectMockDemo();
        System.out.println(obj.modify());
    }
}
