package cn.six.swipe;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import cn.six.aut.R;

/**
 * Activity to demonstrate actions on a {@link ViewPager}.
 */
public class ViewPagerActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        final ViewPager pager = (ViewPager) findViewById(R.id.vp_pager);
        pager.setAdapter(new SimplePagerAdapter());
    }

}

