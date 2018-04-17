package ca.six.jtest.finalt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppleFactoryTest {

    @Test
    public void addListener(){
        AppleAgentListener listener = new AppleAgentListener() { /* do something */ };
        List<AppleAgentListener> listeners = new ArrayList<>();
        AppleAgent agent = mock(AppleAgent.class, RETURNS_SMART_NULLS);

        when(agent.listeners).thenReturn(listeners);
        System.out.println("szw : "+agent);
        System.out.println("szw : "+agent.listeners);

        AppleFactory factory = new AppleFactory(agent);
        factory.addListener(listener); // agent.listeners是空的, 这会报NPE

        verify(agent.listeners).add(listener);
    }
}