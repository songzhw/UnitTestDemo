package cn.six.robolectric;

import android.content.Context;
import android.os.Build;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import cn.six.espresso.aut.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP) // application = *.class
public class BaseRoboTestCase {
    protected Context app = RuntimeEnvironment.application;
}