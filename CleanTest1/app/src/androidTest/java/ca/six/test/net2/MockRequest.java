package ca.six.test.net2;

import ca.six.test.core.MockApiRepo;

/**
 * Created by songzhw on 2016/4/2.
 */
public class MockRequest extends BaseRequest {
    @Override
    public void startRequest(String url, IRespListener alistener) {
        if(alistener != null){
            alistener.onResponsed(MockApiRepo.API_USER);
        }

    }
}
