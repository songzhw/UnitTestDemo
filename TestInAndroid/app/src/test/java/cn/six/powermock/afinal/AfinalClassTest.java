package cn.six.powermock.afinal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AfinalClass.class)
public class AfinalClassTest {

    @Test
    public void testFinalClass(){
        AfinalClass obj = mock(AfinalClass.class);
        assertNotNull(obj);
    }
}