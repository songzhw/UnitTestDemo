package cn.six.robolectric.inject;

public class LifeInjectPresenter implements ILifePresenter {
    private ILifeView view;

    @Override
    public void setView(ILifeView view) {
        this.view = view;
    }

    @Override
    public void getName() {
        view.refresh("presenter name");
    }
}
