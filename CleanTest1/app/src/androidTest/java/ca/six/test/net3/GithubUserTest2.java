package ca.six.test.net3;

/**
 * Created by songzhw on 2016/4/1.
 */

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.google.gson.Gson;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

import ca.six.test.R;
import ca.six.test.core.AsyncIdlingRes;
import ca.six.test.core.Debug;
import ca.six.test.model.User;
import ca.six.test.core.MockApiRepo;
import ca.six.test.ui.GUserActivity2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class GithubUserTest2 {
    @Rule
    public ActivityTestRule<GUserActivity2> actvRule = new ActivityTestRule<GUserActivity2>(GUserActivity2.class);


    @Test
    public void testUser() {
//        User mockUser = new Gson().fromJson(MockApiRepo.API_USER, User.class);
//        GUserActivity2 actv = actvRule.getActivity();
//        Mockito.when(actv.getUser()).thenReturn(mockUser);
//        /* Error : inside when() you don't call method on mock but on some other object !!!  */

        GUserActivity2 actv = actvRule.getActivity();
        actv.httpApi = new MockHttpApis();

        onView(withId(R.id.fab))
                .perform(click());

        onView(withId(R.id.tv_main))
                .check(matches(withText("testInRetrofit")));


    }
}
