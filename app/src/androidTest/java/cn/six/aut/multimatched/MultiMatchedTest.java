package cn.six.aut.multimatched;

import android.app.Activity;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import cn.six.aut.R;
import cn.six.multimatched.MultiMatchedActv;
import cn.six.multiwindow.SuggestActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * @author hzsongzhengwang
 * @date 2015/9/22
 * Copyright 2015 Six. All rights reserved.
 */



@RunWith(AndroidJUnit4.class)
@LargeTest
public class MultiMatchedTest {


    @Rule
    public ActivityTestRule<MultiMatchedActv> actvRule = new ActivityTestRule<MultiMatchedActv>(MultiMatchedActv.class);

    /*
    Note: This test will FAIL!!!!
    it will throw a message about this failure:
    "android.support.test.espresso.AmbiguousViewMatcherException: 'with text: is "abc"' matches multiple views in the hierarchy.
    Problem views are marked with '****MATCHES****' below."
    */
    @Test
    public void testMulti_Fail(){
        onView(withText("abc"))
            .check(matches(withId(R.id.tv_multi_match_one)));

    }

    /*
    Still Error.
    hasSibling() will compare the view itself, which is a bug!
    */
    @Test
    public void testMulti_Fail2(){
        onView(allOf(
                withText("abc"),
                hasSibling(withId(R.id.tv_multi_match_one))
                )
        )
        .check(matches(withId(R.id.tv_multi_match_two)));
    }

    /*
    Still Error.
    hasSibling() will compare the view itself, which is a bug!

    this test proved that hasSibling has a bug

    see the source code of ViewMatchers#hasSibling(), and you will know why this test is failed
    */
    @Test
    public void testMulti_Fail3(){
        onView(
                hasSibling(withId(R.id.tv_multi_match_one))
        )
         .check(matches(withId (R.id.tv_multi_match_two)));
    }


}
