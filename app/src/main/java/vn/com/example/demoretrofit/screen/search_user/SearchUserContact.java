package vn.com.example.demoretrofit.screen.search_user;

import java.util.List;

import vn.com.example.demoretrofit.data.model.User;

public class SearchUserContact {
    interface View {
        void showUser(List<User> users);

        void showError(String error);
    }

    interface Presenter {
        void searchUser(String key);
    }
}
