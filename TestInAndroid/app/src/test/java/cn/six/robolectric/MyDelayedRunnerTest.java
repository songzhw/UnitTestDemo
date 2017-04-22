package cn.six.robolectric;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import cn.six.aut.BuildConfig;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by songzhw on 2016-10-03
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MyDelayedRunnerTest {

    @Test
    public void testNotDelay(){
        MyDelayedRunner runner = new MyDelayedRunner();
        runner.execute();

        assertFalse(runner.isExecuted());
    }

    @Test
    public void testDelay(){
        MyDelayedRunner runner = new MyDelayedRunner();
        runner.execute();
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();
        assertTrue(runner.isExecuted());
    }

}
