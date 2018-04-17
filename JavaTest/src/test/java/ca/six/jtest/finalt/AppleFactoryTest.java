package ca.six.jtest.finalt;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppleFactoryTest {

    @Test
    public void addListener(){
        AppleAgentListener listener = new AppleAgentListener() { /* do something */ };
        AppleAgent agent = mock(AppleAgent.class);
        AppleFactory factory = new AppleFactory(agent);
        factory.addListener(listener);

        verify(agent.listeners).add(listener);
    }
}