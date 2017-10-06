package cn.six;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import cn.six.aut.BuildConfig;
import cn.six.aut.R;
import cn.six.espresso.jump.JumpToActivity;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by songzhw on 2016-09-27
 */
@RunWith(RobolectricTestRunner.class)  // 不用这个， 就在buildActivity时会错的
@Config(constants = BuildConfig.class, sdk=21) // 修复说找不到AndroidManifest的warning
public class Jump2ActivityTest {
    public JumpToActivity toActivity;
    public TextView tv;

    @Before
    public void setUp(){
        Intent it = new Intent();
        it.putExtra(JumpToActivity.KEY_EXTRA_MESSAGE, "20160927Test");

        // Robolectric.buildActivity() will cause tv to be null
        toActivity = Robolectric.buildActivity(JumpToActivity.class)
                        .withIntent(it).create().get();
        tv = (TextView) toActivity.findViewById(R.id.tv_jumpto_display);
    }

    @Test
    public void testActvNotNull() {
        assertNotNull(toActivity);
    }

    @Test
    public void testTextAfterShowing(){
        assertNotNull(tv);
        System.out.println("szw tv.text = "+tv.getText());
        assertEquals("20160927Test", tv.getText());
    }
}
