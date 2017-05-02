package ca.six.todo.addedittask;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.six.todo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddEditTaskFragmentTest {

    @Rule
    public ActivityTestRule<AddEditTaskActivity> actvRule = new ActivityTestRule<>(AddEditTaskActivity. class);

    @Test
    public void createTask_emptyView(){
        onView(withId(R.id.add_task_title))
                .check(matches(withText("")));

        onView(withId(R.id.fab_edit_task_done))
                .perform(click());

        /*
        // SnackBar is not testable for now.
        String message = "TO DOs cannot be empty";
        onView(withText(message))
            .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        */

        // Verify that the activity is still displayed (a correct task would close it).
        onView(withId(R.id.add_task_title))
                .check(matches(isDisplayed()));

    }

//    @Test
//    public void createTask_inputAndSaveTask(){
//        // screen is empty at first
//        onView(withId(R.id.add_task_title))
//                .check(matches(withText("")));
//
//        // type text and save
//        onView(withId(R.id.add_task_title))
//                .perform(typeText("grocery"));
//        onView(withId(R.id.add_task_description))
//                .perform(typeText("tomato, onion, garlic, eggplant"));
//        onView(withId(R.id.fab_edit_task_done))
//                .perform(click());
//
//        // check the result
//
//
//    }

}