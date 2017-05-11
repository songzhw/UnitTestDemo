package cn.six.mockito;

public class MockitoPresenter {
    public IView view;
    public IModel model;

    public MockitoPresenter(IView view, IModel model) {
        this.view = view;
        this.model = model;
    }

    public void inOrderTest(){
        view.setFinished(false);
        model.load(100, new MoCallback() {
            @Override
            public void onSucc() {
                view.setFinished(true);
            }

            @Override
            public void onFail() { }
        });

    }
}

