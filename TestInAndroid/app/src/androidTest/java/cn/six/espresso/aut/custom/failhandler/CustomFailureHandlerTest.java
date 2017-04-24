package cn.six.espresso.aut.custom.failhandler;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.setFailureHandler;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.espresso.FailureHandler;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.base.DefaultFailureHandler;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.espresso.failhandler.CustomFailHandlerActivity;

/**
 * A sample of how to set a non-default {@link FailureHandler}.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class CustomFailureHandlerTest {

    private static final String TAG = "szw";

    @Rule
    public ActivityTestRule<CustomFailHandlerActivity> actvRule = new ActivityTestRule<CustomFailHandlerActivity>(CustomFailHandlerActivity.class);


    @Before
    public void init() {
        setFailureHandler(new CustomFailureHandler(actvRule.getActivity()));
    }

    @Test
    public void customFailHandler() {
        try {
            // has no such button, so espresso would found no such view
            onView(withText("does not exist")).perform(click());
        } catch (MySpecialException expected) {
            Log.e(TAG, "Special exception is special and expected: ", expected);
        }
    }

    /**
     * A {@link FailureHandler} that re-throws {@link NoMatchingViewException} as
     * {@link MySpecialException}. All other functionality is delegated to
     * {@link DefaultFailureHandler}.
     */
    private static class CustomFailureHandler implements FailureHandler {
        private final FailureHandler delegate;

        public CustomFailureHandler(Context targetContext) {
            delegate = new DefaultFailureHandler(targetContext);
        }

        @Override
        public void handle(Throwable error, Matcher<View> viewMatcher) {
            try {
                delegate.handle(error, viewMatcher);
            } catch (NoMatchingViewException e) {
                throw new MySpecialException(e);
            }
        }
    }

    private static class MySpecialException extends RuntimeException {
        MySpecialException(Throwable cause) {
            super(cause);
        }
    }
}