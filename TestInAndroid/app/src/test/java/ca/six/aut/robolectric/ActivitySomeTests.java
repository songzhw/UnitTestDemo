package ca.six.aut.robolectric;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import cn.six.aut.BuildConfig;

/**
 * Created by songzhw on 2016-10-06
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ActivitySomeTests {

    @Test
    public void testConfigChanged(){
        /*
    ActivityController<ExampleActivity> controller = Robolectric.buildActivity(ExampleActivity.class);
    ExampleActivity activity = controller.get();
    ExampleActivityShadow shadow = (ExampleActivityShadow) Shadows.shadowOf(activity);
    shadow.setFragmentManager(fragmentManagerMock);

// 要测试Config Change, 就要再来一个ActvityController与一个Activity
    ActivityController<ExampleActivity> controller2 = Robolectric.buildActivity(ExampleActivity.class);
    ExampleActivity recreatedActivity = controller2.get();
    ExampleActivityShadow recreatedActivityShadow = (ExampleActivityShadow) Shadows.shadowOf(recreatedActivity);
    recreatedActivityShadow.setFragmentManager(fragmentManagerMock);

// 之后再做change:
    // run & verify
    controller.create().start().resume().visible();

    activity.findViewById(R.id.inc_button).performClick();
    activity.findViewById(R.id.inc_button).performClick();

    assertEquals(2, activity.lostCount.count);
    assertEquals(2, activity.retainedCount.count);

    Bundle bundle = new Bundle();
    controller.saveInstanceState(bundle).pause().stop().destroy();
    controller2.create(bundle).start().restoreInstanceState(bundle).resume().visible();

    assertEquals(0, recreatedActivity.lostCount.count);
    assertEquals(2, recreatedActivity.retainedCount.count);
         */
    }

    @Test
    public void testMenu(){
/*
        Menu menu = Shadows.shadowOf(activity).getOptionsMenu();

        MenuItem offlineItem = menu.findItem(R.id.offline);
        assertThat(offlineItem).hasTitle(activity.getText(R.string.offline_text));
*/
    }
}
