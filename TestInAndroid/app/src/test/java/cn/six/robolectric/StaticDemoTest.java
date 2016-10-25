package cn.six.robolectric;

import org.junit.Test;

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
        StaticDemo obj = new StaticDemo();
        int ret = StaticDemo.getNumber();
        assertEquals(1, ret);
    }

    @Test
    public void testStatic02() {
        StaticDemo obj = mock(StaticDemo.class);
        when(obj.getNumber()).thenReturn(3); // Fail : MissingMethodInvocationException

        int ret1 = StaticDemo.getNumber();
        assertNotEquals(3, ret1);
    }
}