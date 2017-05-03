package cn.six.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

public class MockitoPresenterTest {
    @Mock IView view;
    @Mock IModel model;
    @Captor ArgumentCaptor<MoCallback> captor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInOrder(){
        MockitoPresenter presenter = new MockitoPresenter(view, model);
        presenter.inOrderTest();

        verify(model).load(eq(100), captor.capture());
        captor.getValue().onSucc();
        verify(view).setFinished(true);
    }

}