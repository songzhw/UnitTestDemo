package cn.six.powermock.afinal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AfinalClass.class)
public class AfinalClassTest {
    @Test
    public void testFinalClass(){
        AfinalClass obj = PowerMockito.mock(AfinalClass.class);
        assertNotNull(obj);
    }

}