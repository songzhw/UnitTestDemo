package cn.six;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import java.util.List;
import java.util.Set;

import cn.six.aut.BuildConfig;
import cn.six.aut.R;
import cn.six.jump.JumpFromActivity;
import cn.six.jump.JumpToActivity;

import static junit.framework.Assert.assertEquals;

/**
 * Created by songzhw on 2016-09-27
 */
@RunWith(RobolectricTestRunner.class)  // 不用这个， 就在buildActivity时会错的
@Config(constants = BuildConfig.class) // 修复说找不到AndroidManifest的warning
public class JumpFromTest {
    public JumpFromActivity fromActivity;
    public Button btnShow, btnJump;
    public TextView tv;
    public EditText et;

    @Before
    public void setUp(){
        fromActivity = Robolectric.setupActivity(JumpFromActivity.class);
        btnShow = (Button) fromActivity.findViewById(R.id.btn_jumpform_reshow);
        btnJump = (Button) fromActivity.findViewById(R.id.btn_jumpform_jump);
        tv = (TextView) fromActivity.findViewById(R.id.tv_jumpfrom_display);
        et = (EditText) fromActivity.findViewById(R.id.et_jumpfrom);
    }

    @Test
    public void testInputAndJump(){
        et.setText("music");
        btnJump.performClick();

        Intent actualIntent = ShadowApplication.getInstance().getNextStartedActivity();
        Intent expectedIntent = new Intent(fromActivity, JumpToActivity.class);
        expectedIntent.putExtra(JumpToActivity.KEY_EXTRA_MESSAGE, "music");

        assertEquals(expectedIntent.getComponent().getClassName(),
                actualIntent.getComponent().getClassName());
        assertEquals(expectedIntent.getStringExtra(JumpToActivity.KEY_EXTRA_MESSAGE),
                actualIntent.getStringExtra(JumpToActivity.KEY_EXTRA_MESSAGE));
    }

}
