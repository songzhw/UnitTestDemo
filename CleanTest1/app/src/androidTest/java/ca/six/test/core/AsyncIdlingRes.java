package ca.six.test.core;

import android.support.test.espresso.IdlingResource;

import ca.six.test.ui.GUserActivity;

public class AsyncIdlingRes implements IdlingResource {
    private ResourceCallback resourceCallback;

    @Override
    public String getName() {
        return "AsyncIdlingRes";
    }

    @Override
    public boolean isIdleNow() {
        boolean isIdleNow = GUserActivity.isFinishHttp;
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