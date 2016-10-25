package cn.six.robolectric;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.exceptions.misusing.MissingMethodInvocationException;

import ca.six.aut.robolectric.BaseRoboTestCase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by songzhw on 2016-10-24
 */
public class StaticDemoTest extends BaseRoboTestCase{

    @Test
    public void testStatic01() {
        int ret = StaticDemo.getNumber();
        assertEquals(1, ret);
    }


    @Test(expected = MissingMethodInvocationException.class)
    public void testStatic02() {
        StaticDemo obj = mock(StaticDemo.class);
        when(obj.getNumber()).thenReturn(3); // Fail : MissingMethodInvocationException
    }

    @Test
    public void testStatic03() {
        StaticDemoWrapper obj = mock(StaticDemoWrapper.class);
        when(obj.getNumber()).thenReturn(3);

        int ret = obj.getNumber();
        assertEquals(3, ret);
    }


    private class StaticDemoWrapper {
        public int getNumber(){
            return StaticDemo.getNumber();
        }
    }
}