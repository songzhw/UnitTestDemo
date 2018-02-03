package ca.six.jtest.rule;

import java.util.logging.Logger;
import org.junit.Rule;
import org.junit.Test;

public class CustomRuleTest {

    @Rule
    public LoggerRule logger = new LoggerRule();

    @Test
    public void checkOut() {
        final Logger log = logger.getLogger();
        log.warning("Your test is showing!");
    }
/*
Jan 30, 2018 6:40:24 AM ca.six.ju.CustomLogRuleTest checkOut
WARNING: Your test is showing!
*/
}
