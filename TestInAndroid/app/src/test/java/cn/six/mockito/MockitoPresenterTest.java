package cn.six.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
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
        // 因为还没有调用 captor.getValue().onSucc()， 所以这里能成功

        verify(model).load(eq(100), captor.capture());
        captor.getValue().onSucc();
        verify(view).setFinished(false);
        verify(view).setFinished(true);
    }

    @Test
    public void testInOrder4(){
        MockitoPresenter presenter = new MockitoPresenter(view, model);
        presenter.inOrderTest();
        // 因为还没有调用 captor.getValue().onSucc()， 所以这里能成功

        verify(model).load(eq(100), captor.capture());
        captor.getValue().onSucc();
        verify(view).setFinished(true);
        verify(view).setFinished(false);
        /*
        verify(view).setFinished(true);
        verify(view).setFinished(false);
        也能成功，所以说明了InOrder的作用
         */
    }

    @Test
    public void testInOrder2(){
        MockitoPresenter presenter = new MockitoPresenter(view, model);
        presenter.inOrderTest();

        InOrder order = inOrder(view);
        verify(model).load(eq(100), captor.capture());
        captor.getValue().onSucc();
        order.verify(view).setFinished(false);
        order.verify(view).setFinished(true);
    }

    @Test
    public void testInOrder3(){
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);
        firstMock.add("was called first");
        secondMock.add("was called second");

        InOrder order = inOrder(firstMock, secondMock);
        order.verify(firstMock).add("was called first");
        order.verify(secondMock).add("was called second");
    }
}