package vn.com.example.demoretrofit.service.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit sRetrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
