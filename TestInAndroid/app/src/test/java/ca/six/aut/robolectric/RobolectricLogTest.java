package ca.six.aut.robolectric;

import org.junit.Before;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by songzhw on 2016-09-29
 */

public class RobolectricLogTest {

    @Before
    public void setUp(){
        ShadowLog.stream = System.out;
    }

}
