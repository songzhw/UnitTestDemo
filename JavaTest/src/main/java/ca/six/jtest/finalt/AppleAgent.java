package ca.six.jtest.finalt;

import java.util.ArrayList;
import java.util.List;

public class AppleAgent {
    public final List<AppleAgentListener> listeners;

    public AppleAgent() {
        this.listeners = new ArrayList<>();
    }
}

interface AppleAgentListener {
}