package vn.com.example.demoretrofit.service.retrofit;

public class APIUtils {
    private static final String BASE_URL = "https://api.github.com";

    public static InterfaceAPI getInterfaceAPI() {
        return RetrofitClient.getClient(BASE_URL).create(InterfaceAPI.class);
    }
}
