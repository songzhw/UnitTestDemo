package cn.six.espresso.location;

import android.location.Location;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.aut.R;

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
        // thread = Instr: android.support.test.runner.AndroidJUnitRunner
        final AndroidLocationDemo actv = activityTestRule.getActivity();
        actv.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                actv.onLocationChanged(getMockLocation());
            }
        });


        String lastLocation = "latitude  = 30.0 ; longitude = 121.0";
        onView(withId(R.id.tv_simple))
                .check(matches(withText(lastLocation)));
    }

    private Location getMockLocation() {
        Location mockedLocation = new Location("MockedLocation");
        mockedLocation.setLatitude(30);
        mockedLocation.setLongitude(121);
        return mockedLocation;
    }
}

