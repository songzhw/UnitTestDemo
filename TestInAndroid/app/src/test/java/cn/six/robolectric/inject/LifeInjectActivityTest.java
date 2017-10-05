package cn.six.robolectric.inject;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import cn.six.aut.BuildConfig;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LifeInjectActivityTest {
    private LifeInjectActivity actv;
    private ActivityController<LifeInjectActivity> actvController;

    private ILifePresenter presenter = new ILifePresenter() {
        private ILifeView view;

        @Override
        public void setView(ILifeView view) {
            this.view = view;
        }

        @Override
        public void getName() {
            view.refresh("FakeOne");
        }
    };

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
        presenter.setView(actv);
        actv.setPresenter(presenter);

        actvController.create();
        assertEquals("refresh: FakeOne", actv.stage);
    }
}
