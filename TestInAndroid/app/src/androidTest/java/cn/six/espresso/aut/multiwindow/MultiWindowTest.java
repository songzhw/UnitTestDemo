package cn.six.espresso.aut.multiwindow;

/**
 * @author songzhw
 * @date 2015/5/29
 * Copyright 2015 Six. All rights reserved.
 */

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.espresso.aut.R;
import cn.six.espresso.multiwindow.SuggestActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MultiWindowTest {

    @Rule
    public ActivityTestRule<SuggestActivity> actvRule = new ActivityTestRule<SuggestActivity>(SuggestActivity.class);

    private Activity actv;

    @Before
    public void init(){
        actv = actvRule.getActivity();
    }

    @Test
    public void showTwoSuggestion(){
        onView(withId(R.id.autv_suggest))
                .perform(replaceText("china"), closeSoftKeyboard());

        // East China Sea
        // Southern Ocean
        // check both suggestions are displayed
        View decorView = actv.getWindow().getDecorView();
        onView(withText("South China Sea"))
                .inRoot(withDecorView(
                        not(is(decorView))
                ))
                .check(matches(isDisplayed()));

        onView(withText("Southern Ocean"))
                .inRoot(withDecorView(
                        not(is(decorView))
                ))
                .check( doesNotExist() );
    }

    @Test
    public void autoCompleteTextView_clickAndCheck() {
        View decorView = actv.getWindow().getDecorView();

        // Type text into the text view
        onView(withId(R.id.autv_suggest))
                .perform(typeTextIntoFocusedView("South "), closeSoftKeyboard());

        // Tap on a suggestion.
        onView(withText("South China Sea"))
                .inRoot(withDecorView(not(is(decorView))))
                .perform(click());

        // By clicking on the auto complete term, the text should be filled in.
        onView(withId(R.id.autv_suggest))
                .check(matches(withText("South China Sea")));
    }
}
