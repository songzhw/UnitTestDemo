package ca.six.test.net3;

import com.google.gson.Gson;

import java.util.List;

import ca.six.test.core.MockApiRepo;
import ca.six.test.model.Repo;
import ca.six.test.model.User;
import ca.six.test.net.IHttpApi;
import retrofit2.Call;
import retrofit2.http.Path;

/**
 * Created by songzhw on 2016/4/2.
 */
public class MockHttpApis implements IHttpApi {
    @Override
    public Call<User> getUser(@Path("user") String user) {
        User me = new Gson().fromJson(MockApiRepo.API_USER, User.class);
        Call<User> ret = new MockCall<User>(me);
        return ret;
    }

    @Override
    public Call<List<Repo>> listRepos(@Path("user") String user) {
        return null;
    }
}
