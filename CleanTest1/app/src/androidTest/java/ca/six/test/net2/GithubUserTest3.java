package ca.six.test.net2;

/**
 * Created by songzhw on 2016/4/1.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.six.test.R;
import ca.six.test.ui.GUserActivity3;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class GithubUserTest3 {
    @Rule
    public ActivityTestRule<GUserActivity3> actvRule = new ActivityTestRule<GUserActivity3>(GUserActivity3.class);


    @Test
    public void testUser() {
        GUserActivity3 actv = actvRule.getActivity();
        actv.req = new MockRequest();

        onView(withId(R.id.fab))
                .perform(click());

        onView(withId(R.id.tv_main))
                .check(matches(withText("mine3")));


    }
}
