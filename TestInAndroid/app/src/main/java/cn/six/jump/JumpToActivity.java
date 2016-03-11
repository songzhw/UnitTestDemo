package cn.six.jump;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import cn.six.aut.R;

public class JumpToActivity extends Activity {

    // The name of the extra data sent through an {@link Intent}.
    public final static String KEY_EXTRA_MESSAGE =
            "com.example.android.testing.espresso.basicsample.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_to);

        // Get the message from the Intent.
        Intent intent = getIntent();
        String message = intent.getStringExtra(KEY_EXTRA_MESSAGE);

        // Show message.
        ((TextView)findViewById(R.id.tv_jumpto_display)).setText(message);
    }

    static protected Intent newStartIntent(Context context, String message) {
        Intent newIntent = new Intent(context, JumpToActivity.class);
        newIntent.putExtra(KEY_EXTRA_MESSAGE, message);
        return newIntent;
    }
}
