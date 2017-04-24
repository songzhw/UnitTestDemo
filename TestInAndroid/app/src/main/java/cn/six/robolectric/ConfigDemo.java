package cn.six.robolectric;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import cn.six.espresso.aut.R;

/**
 * Created by songzhw on 2017-03-30
 */

public class ConfigDemo extends Activity implements View.OnClickListener {
    public int lost = 0, retain = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        TextView tv = (TextView) findViewById(R.id.tvOne);
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        lost++;
        retain++;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key933", retain);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        retain = savedInstanceState.getInt("key933", 0);
    }
}
