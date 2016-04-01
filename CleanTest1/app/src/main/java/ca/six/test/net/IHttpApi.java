package ca.six.test.net;

import java.util.List;

import ca.six.test.model.Repo;
import ca.six.test.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by songzhw on 2016/4/1.
 */
public interface IHttpApi {
    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);


    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);
}
