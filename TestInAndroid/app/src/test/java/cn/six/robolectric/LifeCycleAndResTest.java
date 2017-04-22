package cn.six.robolectric;

import android.app.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import cn.six.aut.BuildConfig;
import cn.six.aut.R;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)  // 不用这个， 就在buildActivity时会错的
@Config(constants = BuildConfig.class) // 修复说找不到AndroidManifest的warning
public class LifeCycleAndResTest {

    @Test
    public void testLifecycle(){
        ActivityController<LifeCycleActivity> actvController =
            Robolectric.buildActivity(LifeCycleActivity.class).create();
        LifeCycleActivity actv = actvController.get();

        assertEquals("onCreate", actv.stage);

        actvController.start();
        assertEquals("onStart", actv.stage);

        actvController.resume();
        assertEquals("onResume", actv.stage);

        actvController.destroy();
        assertEquals("onDestroy", actv.stage);
    }


    @Test
    public void testResources() {
        Application application = RuntimeEnvironment.application;
        String appName = application.getString(R.string.app_name);
        assertEquals("AndroidAutoTest", appName);
    }
}
