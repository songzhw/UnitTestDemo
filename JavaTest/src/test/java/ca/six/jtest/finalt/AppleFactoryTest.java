package ca.six.jtest.finalt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AppleFactoryTest {

    @Test
    public void addListener(){
        AppleAgent agent = new AppleAgent();

        AppleAgentListener listener = new AppleAgentListener() { /* do something */ };
        AppleFactory factory = new AppleFactory(agent);

        assertFalse(agent.listeners.contains(listener));

        factory.addListener(listener); // agent.listeners是空的, 这会报NPE

        assertTrue(agent.listeners.contains(listener));
    }
}