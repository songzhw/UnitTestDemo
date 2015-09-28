package cn.six.aut;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.jump.JumpFromActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;

/**
 * @author songzhw
 * @date 2015/5/27
 * Copyright 2015 Six. All rights reserved.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class JumpActivityTest {
    public String str = "Espresso";

    @Rule
    public ActivityTestRule<JumpFromActivity> actvRule = new ActivityTestRule<>(JumpFromActivity.class);

    @Test
    public void szwChangeText_sameActv() {
        onView(withId(R.id.et_jumpfrom))
                .perform(typeText(str), closeSoftKeyboard());
        onView(withId(R.id.btn_jumpform_reshow))
                .perform(click());

        // check the result
        onView(withId(R.id.tv_jumpfrom_display))
                .check(matches(withText(str)));
    }

    @Test
    public void szwJump_twoActv() {
        onView(withId(R.id.et_jumpfrom))
                .perform(typeText(str), closeSoftKeyboard());
        onView(withId(R.id.btn_jumpform_jump))
                .perform(click());

        // Clicking launches a new activity that shows the text entered above. You don't need to do
        // anything special to handle the activity transitions. Espresso takes care of waiting for the
        // new activity to be resumed and its view hierarchy to be laid out.
        onView(withId(R.id.tv_jumpto_display))
                .check(matches(withText(str)));

        // going back to the previous activity
        pressBack();
        onView(withId(R.id.et_jumpfrom))
                .check(matches(withText( containsString("Espresso") )));
    }


}
