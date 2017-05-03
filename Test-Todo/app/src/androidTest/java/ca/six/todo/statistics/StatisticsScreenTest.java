package ca.six.todo.statistics;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import ca.six.todo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class StatisticsScreenTest {
    @Rule
    public ActivityTestRule<StatisticsActivity> actvRule = new ActivityTestRule<>(StatisticsActivity. class);

    @Test
    public void emptyTask_showEmptyView(){
        onView(withText("You have no tasks."))
                .check(matches(isDisplayed()));
    }

}