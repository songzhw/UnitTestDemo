package cn.six.aut.async;

/**
 * @author hzsongzhengwang
 * @date 2015/6/2
 * Copyright 2015 NetEase. All rights reserved.
 */

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


import cn.six.async.AsyncTaskActivity;
import cn.six.aut.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsyncTest {

    @Rule
    public ActivityTestRule<AsyncTaskActivity> actvRule = new ActivityTestRule<AsyncTaskActivity>(AsyncTaskActivity.class);


    @Test
    public void async(){
        onView(withId(R.id.btn_async_start))
                .perform(click());

        // Make sure Espresso does not time out
        IdlingPolicies.setMasterPolicyTimeout(6, TimeUnit.MILLISECONDS);
        IdlingPolicies.setIdlingResourceTimeout(10, TimeUnit.MILLISECONDS);

        IdlingResource idlingResource = new AsyncIdlingRes();
        Espresso.registerIdlingResources(idlingResource);


        onView(withId(R.id.tv_async_result))
                .check(matches(withText("szw ok")));

        Espresso.unregisterIdlingResources(idlingResource);
    }

}
