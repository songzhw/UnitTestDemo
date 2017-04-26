package cn.six.mockito;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class ApplePresenterTest {
    @Test
    public void foo() throws Exception {
        ApplePresenter presenter = new ApplePresenter();
        presenter.foo(true);
        verify(presenter).bar();
    }

}