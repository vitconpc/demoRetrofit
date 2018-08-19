package vn.com.example.demoretrofit.data.datasource.remote;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.example.demoretrofit.common.Constants;
import vn.com.example.demoretrofit.data.datasource.DataSource;
import vn.com.example.demoretrofit.data.model.UserResponse;
import vn.com.example.demoretrofit.service.retrofit.APIUtils;
import vn.com.example.demoretrofit.service.retrofit.InterfaceAPI;

public class SearchUserRemoteDataSource implements DataSource.RemoteDataSource {
    private static SearchUserRemoteDataSource sSearchUserRemoteDataSource;
    private InterfaceAPI mAPI;

    public SearchUserRemoteDataSource(InterfaceAPI mAPI) {
        this.mAPI = mAPI;
    }

    public static SearchUserRemoteDataSource getInstance() {
        if (sSearchUserRemoteDataSource == null) {
            sSearchUserRemoteDataSource = new SearchUserRemoteDataSource(APIUtils.getInterfaceAPI());
        }
        return sSearchUserRemoteDataSource;
    }

    @Override
    public void searchUserbyName(String key, final DataSource.OnFetchDataListener listener) {
        mAPI.searchByName(key).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body() != null) {
                    listener.onFetchDataSuccess(response.body().getUsers());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                listener.onFetchDataError(Constants.SERVER_ERROR);
            }
        });
    }

    @Override
    public void getImage(DataSource.OnGetImageListener listener) {

    }
}
