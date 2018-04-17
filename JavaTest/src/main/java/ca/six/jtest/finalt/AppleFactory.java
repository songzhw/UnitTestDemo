package ca.six.jtest.finalt;

public class AppleFactory {
    AppleAgent agent;

    public AppleFactory(AppleAgent agent) {
        this.agent = agent;
    }

    public void addListener(AppleAgentListener listener){
        agent.listeners.add(listener);
    }
}
