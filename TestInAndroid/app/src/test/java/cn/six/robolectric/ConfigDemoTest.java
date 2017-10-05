package cn.six.robolectric;

import android.os.Bundle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import cn.six.aut.BuildConfig;
import cn.six.aut.R;

import static org.junit.Assert.*;

/**
 * Created by songzhw on 2017-03-30
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class ConfigDemoTest {
    @Test
    public void rotateScreen(){
        // 默认的旋屏， 会干掉老Activity， 创建新Activity。 所以这里要两个ActivityController
        ActivityController<ConfigDemo> c1 = Robolectric.buildActivity(ConfigDemo.class);
        ConfigDemo actv1 = c1.get();
        ActivityController<ConfigDemo> c2 = Robolectric.buildActivity(ConfigDemo.class);
        ConfigDemo actv2 = c2.get();

        // 进入页面
        c1.create().start().resume().visible();
        actv1.findViewById(R.id.tvOne).performClick();
        actv1.findViewById(R.id.tvOne).performClick();
        assertEquals(2, actv1.lost);
        assertEquals(2, actv1.retain);

        // 旋屏
        Bundle bundle = new Bundle(); // onSaveInstanceState(bundle)要求一个bundle为入参，所以这里要初始化下先
        c1.saveInstanceState(bundle).pause().stop().destroy(); // 老Activity被干掉
        c2.create(bundle).start().restoreInstanceState(bundle).resume().visible();//新建一个新Activity
        assertEquals(0, actv2.lost); //因为onSaveInstanceState()里没有存lost的值，所以这里应该仍为0
        assertEquals(2, actv2.retain);
    }
}