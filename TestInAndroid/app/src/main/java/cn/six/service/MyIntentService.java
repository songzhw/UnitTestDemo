package cn.six.service;

import android.app.IntentService;
import android.content.Intent;


public class MyIntentService extends IntentService {
    public static final String ACTION_FOO = "cn.six.service.action.FOO";

    public static final String EXTRA_PARAM1 = "cn.six.service.extra.PARAM1";
    public static final String EXTRA_PARAM2 = "cn.six.service.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            }
        }
    }

    private void handleActionFoo(String param1, String param2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
