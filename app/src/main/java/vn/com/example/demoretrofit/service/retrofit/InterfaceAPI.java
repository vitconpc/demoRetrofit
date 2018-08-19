package vn.com.example.demoretrofit.service.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vn.com.example.demoretrofit.data.model.UserResponse;

public interface InterfaceAPI {
    @GET("/search/users?sort=followers&order=desc")
    Call<UserResponse> searchByName(@Query("q") String q);
}
