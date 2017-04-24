package cn.six.espresso.aut.list;

import android.support.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import cn.six.espresso.list.ItemData;

import static org.hamcrest.Matchers.equalTo;

// This is a util class, so it is not extend any ***Match class.
// However, it custom the specific way that how to match a ItemData object to a String in our ListView
// the BounderMatcher#matchesSafely() is the key function!

public class MyAdapterMatcher {
    // public method, 公开出去， 做为自定义Matcher
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