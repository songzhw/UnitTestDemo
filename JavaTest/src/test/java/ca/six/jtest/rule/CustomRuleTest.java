package ca.six.jtest.rule;

import java.util.logging.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomRuleTest {

    @Rule
    public LoggerRule logger = new LoggerRule();

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            System.out.println("  --> watcherman : apply()");
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println("  --> watchman : succeeded()");
            super.succeeded(description);
        }
    };

    @Test
    public void checkOut() {
        final Logger log = logger.getLogger();
        log.warning("Your test is showing!");
    }

}

