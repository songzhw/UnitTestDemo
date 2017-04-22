package cn.six.robolectric.custom;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.bytecode.InstrumentationConfiguration;

public class CustomShadowRunner extends RobolectricTestRunner {

    // CF. like View's four CF
    public CustomShadowRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    public InstrumentationConfiguration createClassLoaderConfig(Config config) {
        InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
        builder.addInstrumentedClass(Person.class.getName()); // add the class that needs to be "shadowed"
        return builder.build();
    }
}