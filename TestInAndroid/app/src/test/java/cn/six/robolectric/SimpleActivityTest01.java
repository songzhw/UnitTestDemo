package cn.six.robolectric;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import cn.six.aut.BuildConfig;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk=21)
public class SimpleActivityTest01 {

    @Test
    public void testActivity(){
        /*
        This is may get error
         Activity actv = Robolectric.buildActivity().create().get();
         TextView tv = (TextView)actv.findViewById(R.id.tv);
         */
    }
}
