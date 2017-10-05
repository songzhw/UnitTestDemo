package cn.six.espresso.menu;

import android.os.Build;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.aut.R;


/**
 * @author songzhw
 * @date 2015/9/28
 * Copyright 2015 Six. All rights reserved.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MenuTest {

    @Rule
    public ActivityTestRule<MenuActivity> actvRule = new ActivityTestRule<MenuActivity>(MenuActivity.class);

    @Test
    public void showPopupMenu(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB){
            // PopupMenu only available since api 11
            Log.d("szw", "the android version is too low !");
            return;
        }

        // show the PopupMenu
        onView(withText("popup_item_1_text"))
                .check(doesNotExist());
        onView(withId(R.id.btn_popup))
                .perform(click());
        onView(withText("popup_item_1_text"))
                .check(matches(isDisplayed()));

        // click the PopupMenu
        onView(withText("popup_item_1_text"))
                .perform(click());
        onView(withId(R.id.tv_menu_result))
                .check(matches(withText("popup_item_1_text")));
    }


    @Test
    public void showContextMenu(){
        onView(withId(R.id.tv_context_menu))
                .perform(longClick());
        onView(withText("context_item_2_text"))
                .perform(click());
        onView(withId(R.id.tv_menu_result))
                .check(matches(withText("context_item_2_text")));
    }

    @Test
    public void showOptionMenu(){
        onView(isRoot())
                .perform(pressMenuKey());
        onView(withText("options_item_3_text"))
                .perform(click());
        onView(withId(R.id.tv_menu_result))
                .check(matches(withText("options_item_3_text")));

    }


}
