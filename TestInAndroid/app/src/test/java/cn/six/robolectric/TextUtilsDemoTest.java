package cn.six.robolectric;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by songzhw on 2016-10-25
 *
 * 没有出现网上说的， 找不到TextUtils的问题。
 * 看来新版本Robolectric新加入了对TextUtils的支持
 */
public class TextUtilsDemoTest extends BaseRoboTestCase {

    @Test
    public void isEmpty() throws Exception {
        TextUtilsDemo obj = new TextUtilsDemo();
        boolean actual = obj.isEmpty("");
        assertEquals(true, actual);
    }

    @Test
    public void isEmpty2() throws Exception {
        TextUtilsDemo obj = new TextUtilsDemo();
        boolean actual = obj.isEmpty("abc");
        assertEquals(false, actual);
    }

}