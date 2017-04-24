package cn.six.espresso.aut.sync2;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.CountingIdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cn.six.espresso.async2.IServer;
import cn.six.espresso.async2.Sync2Actv;
import cn.six.espresso.aut.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author songzhw
 * @date 2015/9/24
 * Copyright 2015 Six. All rights reserved.
 */

/*
android.support.test.espresso.contrib.CountingIdlingResource

CountingIdlingResource是属于 espresso-contrib包里的。

 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class Sync2Test {
    @Rule
    public ActivityTestRule<Sync2Actv> actvRule = new ActivityTestRule<Sync2Actv>(Sync2Actv.class);

    @Before
    public void init(){
        CountingIdlingResource idling = new CountingIdlingResource("Sync2");
        Espresso.registerIdlingResources(idling);

        IServer realServer = actvRule.getActivity().getServer();
        ProxyServer proxy = new ProxyServer(idling, realServer);
        actvRule.getActivity().setServer(proxy);
    }



    @Test
    public void testSync2(){
        onView(withId(R.id.btn_async_start))
                .perform(click());

        onView(withId(R.id.tv_async_result))
                .check(matches(withText("Hello from szw")));
    }


    private class ProxyServer implements IServer{
        private IServer real;
        private CountingIdlingResource idling;

        public ProxyServer(CountingIdlingResource idling, IServer real) {
            this.idling = idling;
            this.real = real;
        }


        @Override
        public String getResult() {
            idling.increment();
            try{
                // Activity自己的server,即real,　会有延时操作。
                // 所以这里要用increment(), decrement()来强迫等待。
                return real.getResult();
            } finally{
                idling.decrement();
            }
        }
    }
    // 这里用real.getResult()， 就是仍是要做Sync2Actv里的逻辑
    // 但因为要Espresso等待Thread的运行，所以这里要有CountingIdlingResource

}
