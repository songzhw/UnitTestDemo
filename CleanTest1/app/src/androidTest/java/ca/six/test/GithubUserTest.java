package ca.six.test;

/**
 * Created by songzhw on 2016/4/1.
 */

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import ca.six.test.core.AsyncIdlingRes;
import ca.six.test.ui.GUserActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class GithubUserTest {
    @Rule
    public ActivityTestRule<GUserActivity> actvRule = new ActivityTestRule<GUserActivity>(GUserActivity.class);

    @Test
    public void testFirst(){
        onView(withId(R.id.tv_main))
                .check(matches(withText("Hello World!")));
    }

    @Test
    public void testUser(){
        onView(withId(R.id.fab))
                .perform(click());

        // Make sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(6, TimeUnit.SECONDS);
        IdlingPolicies.setIdlingResourceTimeout(10, TimeUnit.SECONDS);

        IdlingResource idlingResource = new AsyncIdlingRes();
        Espresso.registerIdlingResources(idlingResource);


        onView(withId(R.id.tv_main))
                .check(matches(withText("songzhw")));

        Espresso.unregisterIdlingResources(idlingResource);

    }
}
