package cn.six.espresso.swipe;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.aut.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


import static android.support.test.espresso.contrib.DrawerActions.closeDrawer;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;


/**
 * @author songzhw
 * @date 2015/9/29
 * Copyright 2015 Six. All rights reserved.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SwipeTest {
    @Rule
    public ActivityTestRule<ViewPagerActivity> actvRule =
            new ActivityTestRule<ViewPagerActivity>(ViewPagerActivity.class);

    @Test
    public void testSwipe() {
        onView(withText("Position #0")).check(matches(isDisplayed()));
        onView(withId(R.id.vp_pager)).perform(swipeLeft());
        onView(withText("Position #1")).check(matches(isDisplayed()));

        onView(withId(R.id.vp_pager)).perform(swipeRight());
        onView(withText("Position #0")).check(matches(isDisplayed()));
        onView(withId(R.id.vp_pager)).perform(swipeRight());
        onView(withText("Position #0")).check(matches(isDisplayed())); // still visible
    }



}
