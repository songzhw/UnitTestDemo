package ca.six.jtest.rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ConsumedTime implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement(){
            @Override
            public void evaluate() throws Throwable {
                long start = System.currentTimeMillis();
                base.evaluate();
                long end = System.currentTimeMillis();
                System.out.println("        [ consumed = "+(end - start)+"ms ]");
            }
        };
    }
}
