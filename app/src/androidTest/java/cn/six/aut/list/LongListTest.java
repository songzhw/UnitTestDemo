package cn.six.aut.list;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import cn.six.aut.R;
import cn.six.list.ItemData;
import cn.six.list.LongListActivity;

/**
 * @author hzsongzhengwang
 * @date 2015/5/27
 * Copyright 2015 Six. All rights reserved.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LongListTest {

    @Rule
    public ActivityTestRule<LongListActivity> mActivityRule = new ActivityTestRule<>( LongListActivity.class);

    @Test
    public void firstItemDisplay(){
        onView( withText("item: 0"))
                .check( matches(isDisplayed()));
    }

    @Test
    public void lastItemNotDisplay(){
        onView(withText("item: 99"))
                .check(doesNotExist());
    }

    @Test
    public void scrollEnd(){
        onRow("item: 99")
//                .check(matches(isCompletelyDisplayed()));
        .check(matches(isDisplayed()));
    }

// -----------------------------------------------------------------
    // The text view "item: 50" may not exist if we haven't scrolled to it.
    // By using onData api we tell Espresso to look into the Adapter for an item matching
    // the matcher we provide it. Espresso will then bring that item into the view hierarchy
    // and we can click on it.
    @Test
    public void clickOnItem50(){
        onRow("item: 50")
                .perform(click());
        onView(withId(R.id.tv_list_selection_row_value))
                .check(matches(withText("50")));
    }


    // ViewMatchers.isChecked() : Returns a matcher that accepts if and only if the view is a CompoundButton (or subtype of) and is in checked state.
    @Test
    public void clickOnItem50InToggle(){
        onRow("item: 50")
                .onChildView( withId(R.id.tb_list_item) )
                .perform(click())
                .check(matches(isChecked()))  // 刚开始是关的，点击之后，测试是否tb是打开的
                .perform(click())
                .check( matches(ViewMatchers.isNotChecked()) ); // 再次点击tb， 测试tb是否是关闭了
    }

    /** Make sure that clicking on the toggle button doesn't trigger a click on the row. */
    @Test
    public void clickOnTb2(){
        onRow("item: 20")
                .onChildView( withId(R.id.tv_list_item) )
                .perform(click());
        onRow("item: 50")
                .onChildView( withId(R.id.tb_list_item) )
                .perform(click());
        onView(withId(R.id.tv_list_selection_row_value))
                .check(matches(withText("20")));
    }

// -----------------------------------------------------------------

    // Espresso.onData(matcher) : Creates an DataInteraction for a data object displayed by the application.
    // DataInteraction : An interface to interact with data displayed in AdapterViews.
    // Matchers : http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
    //    allOf(matcher...) : 全符合条件则会返回Matcher对象
    //    instanceof() : 判断是不是参数的类型, return Matcher
    //    is(matcher) :  只是包了一层matcher而已，让测试语句更像人说的话
    //    is(T) :  是 is( equalTo(x)) 的缩写而已
    //    hasEntry(keyMatcher, valueMatcher) : 要求map至少有一项的key满足keyMatcher， 同时此项的value要满足valueMatcher
    private DataInteraction onRow(String str) {
        DataInteraction dataInteraction = onData(
                allOf(
                        instanceOf(ItemData.class),
                        MyAdapterMatcher.withName(str)
                )
        );

        return dataInteraction;
    }

}
