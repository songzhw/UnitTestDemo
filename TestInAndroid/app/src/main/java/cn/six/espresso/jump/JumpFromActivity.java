package cn.six.espresso.jump;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.six.aut.R;


public class JumpFromActivity extends Activity implements View.OnClickListener {

    // The TextView used to display the message inside the Activity.
    private TextView mTextView;

    // The EditText where the user types the message.
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_from);

        // Set the listeners for the buttons.
        findViewById(R.id.btn_jumpform_reshow).setOnClickListener(this);
        findViewById(R.id.btn_jumpform_jump).setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.tv_jumpfrom_display);
        mEditText = (EditText) findViewById(R.id.et_jumpfrom);
    }

    @Override
    public void onClick(View view) {
        // Get the text from the EditText view.
        final String text = mEditText.getText().toString();

        switch (view.getId()) {
            case R.id.btn_jumpform_reshow:
                // First button's interaction: set a text in a text view.
                mTextView.setText(text);
                break;
            case R.id.btn_jumpform_jump:
                // Second button's interaction: start an activity and send a message to it.
                Intent intent = JumpToActivity.newStartIntent(this, text);
                startActivity(intent);
                break;
        }
    }
}
