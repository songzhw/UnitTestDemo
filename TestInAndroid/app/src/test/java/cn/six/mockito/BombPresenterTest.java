package cn.six.mockito;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class BombPresenterTest {

    @Test(expected = BombCallBarException.class)
    public void foo() throws Exception {
        BombPresenter presenter = spy(new BombPresenter());
        doThrow(new BombCallBarException())
                .when(presenter).bar();
        presenter.foo(true);
    }

}

class BombCallBarException extends RuntimeException{
}