package ca.six.test.net3;

import java.io.IOException;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by songzhw on 2016/4/2.
 */
public class MockCall<T> implements Call<T> {
    private T t;

    public MockCall(T t){
        this.t = t;
    }

    @Override
    public Response<T> execute() throws IOException {
        return Response.success(t);
    }

    @Override
    public void enqueue(Callback<T> callback) {

    }

    @Override
    public boolean isExecuted() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public Call<T> clone() {
        return null;
    }

    @Override
    public Request request() {
        return null;
    }
}
