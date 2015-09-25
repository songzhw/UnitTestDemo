package cn.six.aut;

/**
 * @author hzsongzhengwang
 * @date 2015/5/22
 * Copyright 2015 Six. All rights reserved.
 */

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.first.OneActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class OneActivityTest{

    @Rule
    public ActivityTestRule<OneActivity> actvRule = new ActivityTestRule<>(OneActivity.class);

    @Test
    public void szwHelloWorld(){
        // static引入 Espresso, ViewMatchers, ViewAssertions
        Activity actv = actvRule.getActivity();
        String hello = actv.getResources().getString(R.string.hello_world);
        onView(withText(hello))
            .check(matches(isDisplayed()));
    }

}
