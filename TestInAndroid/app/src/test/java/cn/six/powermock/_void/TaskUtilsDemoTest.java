package cn.six.powermock._void;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import cn.six.powermock.TaskUtils;

import static junit.framework.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TaskUtils.class})
public class TaskUtilsDemoTest {
    @Test
    public void testFoo() {

        TaskUtilsDemo demo = mock(TaskUtilsDemo.class);
        demo.foo();
        assertEquals(23, demo.id);

    }

    @Test
    public void testFoo2() {
        doNothing().when(TaskUtils.class);

        TaskUtilsDemo demo = mock(TaskUtilsDemo.class);
        demo.foo();
        assertEquals(0, demo.id);

    }
}