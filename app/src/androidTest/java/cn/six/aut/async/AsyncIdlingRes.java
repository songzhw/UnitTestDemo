package cn.six.aut.async;


/**
 * @author hzsongzhengwang
 * @date 2015/6/5
 * Copyright 2015 Six. All rights reserved.
 */
import android.support.test.espresso.IdlingResource;

import cn.six.async.AsyncTaskActivity;

public class AsyncIdlingRes implements IdlingResource {
    private ResourceCallback resourceCallback;

    @Override
    public String getName() {
        return "AsyncIdlingRes";
    }

    @Override
    public boolean isIdleNow() {
        boolean isIdleNow = AsyncTaskActivity.isFinished;
        if(isIdleNow){
            resourceCallback.onTransitionToIdle();
        }
        return isIdleNow;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }
}
