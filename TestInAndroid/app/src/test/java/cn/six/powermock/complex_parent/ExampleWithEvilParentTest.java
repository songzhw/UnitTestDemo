package cn.six.powermock.complex_parent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertEquals;
import static org.powermock.api.support.membermodification.MemberMatcher.constructor;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ExampleWithEvilParent.class)
public class ExampleWithEvilParentTest {

    @Test
    public void testSuppressConstructorOfEvilParent() throws Exception {
        suppress(constructor(EvilParent.class));
        // supress(method(***.class, "methodName");

        final String message = "myMessage";
        ExampleWithEvilParent tested = new ExampleWithEvilParent(message);
        assertEquals(message, tested.getMessage());
    }
}