package cn.six.robolectric.inject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

// since this is a passive view, it's not necessary to mock and inject a presetner!
public class LifeInjectActivity extends Activity implements ILifeView {
    private ILifePresenter presenter;
    public String stage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stage = "onCreate";

        if(presenter == null){
            presenter = new LifeInjectPresenter();
            presenter.setView(this);
        }
        presenter.getName();
    }

    public void setPresenter(ILifePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void refresh(String name) {
        stage = "refresh: " + name;
        System.out.println("szw view refrsh(" + name + ");");
    }


    @Override
    protected void onStart() {
        super.onStart();
        stage = "onStart";
    }

    @Override
    protected void onResume() {
        super.onResume();
        stage = "onResume";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stage = "onDestroy";
    }
}
