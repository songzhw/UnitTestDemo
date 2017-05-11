package cn.six.hard.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeDataDemoTest {
    @Test
    public void foo_nullData_valueIs1() throws Exception {
        SomeDataList.getInstance().setList(null);

        SomeDataDemo obj = new SomeDataDemo();
        obj.foo();

        assertEquals(1, obj.value);
    }



}