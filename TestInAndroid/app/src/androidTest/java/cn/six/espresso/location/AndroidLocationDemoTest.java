package cn.six.espresso.location;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.espresso.aut.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AndroidLocationDemoTest {
    @Rule
    public ActivityTestRule<AndroidLocationDemo> activityTestRule =
            new ActivityTestRule<>(AndroidLocationDemo.class);

    @Test
    public void testInit_whenHasPermission_showLocation() {
        String lastLocation = "latitude  = " + 30 + " ; longitude = " + 121;
        onView(withId(R.id.tv_simple))
                .check(matches (withText(lastLocation)));
    }
}
