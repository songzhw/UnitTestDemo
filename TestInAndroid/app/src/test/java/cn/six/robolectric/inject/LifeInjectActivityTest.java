package cn.six.robolectric.inject;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import cn.six.espresso.aut.BuildConfig;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LifeInjectActivityTest {
    @Mock
    ILifePresenter presenter;
    private LifeInjectActivity actv;
    private ActivityController<LifeInjectActivity> actvController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        actvController = Robolectric.buildActivity(LifeInjectActivity.class);
        actv = actvController.get();
    }

    @Test
    public void testNoInject_everythingIsNormal() {
        assertEquals(null, actv.stage);

        actvController.create();
        assertEquals("refresh: presenter name", actv.stage);

    }

    @Test
    public void testLifeInjectIsSuccessful() {
        actv.setPresenter(presenter);

        actvController.create();
    }
}
