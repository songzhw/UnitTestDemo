package cn.six.powermock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TaskUtils.class})
public class ShowSthPresenterTest {

    @Captor
    ArgumentCaptor<ITaskCallback> captor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendTask_verfiySuccess(){
        mockStatic(TaskUtils.class);

        ShowSthPresenter presenter = new ShowSthPresenter();
        presenter.sendTask(100);

        verifyStatic();
        TaskUtils.sendTask(eq(100), captor.capture());
        captor.getValue().onSucc("test");

        assertEquals("test", presenter.value);
    }
}