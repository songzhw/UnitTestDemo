package cn.six.robolectric.custom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.internal.ShadowExtractor;

import cn.six.espresso.aut.BuildConfig;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(CustomShadowRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, shadows = {ShadowPerson.class})
public class CustomShadowTest {

    @Test
    public void testCustomShadow(){
        Person me = new Person("song");
        assertNotEquals("name = song", me.getInfo());
        assertEquals("mockedInfo", me.getInfo()); // 实际上调用的是Shadow对象的getInfo()方法
    }

    @Test
    public void testShadowItself(){
        Person me = new Person("song");
        ShadowPerson shadowMe = (ShadowPerson) ShadowExtractor.extract(me);
        assertEquals("mockedInfo", shadowMe.getInfo());
    }

}