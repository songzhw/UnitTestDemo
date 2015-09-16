package cn.six.aut.list;

import android.support.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import cn.six.list.ItemData;

import static org.hamcrest.Matchers.equalTo;

public class MyAdapterMatcher {
    public static Matcher<Object> withName(String expectedText) {
        return withName(equalTo(expectedText));
    }

    public static Matcher<Object> withName(final Matcher<String> expectedObject) {
        return new BoundedMatcher<Object, ItemData>(ItemData.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with name: " + description);
            }

            @Override
            protected boolean matchesSafely(ItemData itemData) {
                return expectedObject.matches(itemData.name);
            }
        };
    }
}