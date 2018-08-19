package vn.com.example.demoretrofit.screen.search_user;

import java.util.List;

import vn.com.example.demoretrofit.data.datasource.DataSource;
import vn.com.example.demoretrofit.data.model.User;
import vn.com.example.demoretrofit.data.reponsitory.UserRepository;

public class SearchUserPresenter implements SearchUserContact.Presenter, DataSource.OnFetchDataListener<User> {
    private SearchUserContact.View mView;
    private UserRepository mUserRepository;


    public SearchUserPresenter(SearchUserContact.View mView) {
        this.mView = mView;
        mUserRepository = UserRepository.getInstance();
    }


    @Override
    public void searchUser(String key) {
        mUserRepository.searchUser(key, this);
    }

    @Override
    public void onFetchDataSuccess(List<User> users) {
        mView.showUser(users);
    }

    @Override
    public void onFetchDataError(String error) {
        mView.showError(error);
    }
}
