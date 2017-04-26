package cn.six.mockito;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class BombPresenterTest {

    @Test(expected = IllegalArgumentException.class)
    public void foo() throws Exception {
        BombPresenter presenter = spy(new BombPresenter());
        doThrow(new IllegalArgumentException())
                .when(presenter).bar();
        presenter.foo(true);
    }

}