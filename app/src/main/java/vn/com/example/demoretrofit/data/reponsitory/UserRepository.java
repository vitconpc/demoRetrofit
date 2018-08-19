package vn.com.example.demoretrofit.data.reponsitory;

import vn.com.example.demoretrofit.data.datasource.DataSource;
import vn.com.example.demoretrofit.data.datasource.remote.SearchUserRemoteDataSource;

public class UserRepository {
    private static UserRepository sUserRepository;
    private DataSource.RemoteDataSource mRemoteDataSource;

    public UserRepository(DataSource.RemoteDataSource mRemoteDataSource) {
        this.mRemoteDataSource = mRemoteDataSource;
    }

    public static UserRepository getInstance() {
        if (sUserRepository == null) {
            sUserRepository = new UserRepository(SearchUserRemoteDataSource.getInstance());
        }
        return sUserRepository;
    }

    public void searchUser(String key, DataSource.OnFetchDataListener listener) {
        mRemoteDataSource.searchUserbyName(key, listener);
    }
}
