package vn.com.example.demoretrofit.screen.search_user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import vn.com.example.demoretrofit.R;
import vn.com.example.demoretrofit.common.Constants;
import vn.com.example.demoretrofit.data.model.User;

public class SearchUserActivity extends AppCompatActivity implements SearchUserContact.View, OnClickRecycler, View.OnClickListener {

    private EditText mTextSearch;
    private SearchUserContact.Presenter mPresenter;
    private RecyclerView mRecyclerUsers;
    private SearchUserAdapter mAdapter;
    private List<User> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        initView();
    }

    private void initView() {
        mTextSearch = findViewById(R.id.text_search);
        findViewById(R.id.button_search).setOnClickListener(this);
        mRecyclerUsers = findViewById(R.id.recycler_users);
        mUsers = new ArrayList<>();
        mAdapter = new SearchUserAdapter(this, mUsers, this);
        mRecyclerUsers.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerUsers.setHasFixedSize(true);
        mRecyclerUsers.setNestedScrollingEnabled(true);
        mRecyclerUsers.setAdapter(mAdapter);
        mPresenter = new SearchUserPresenter(this);
    }

    @Override
    public void onClick(View v) {
        mPresenter.searchUser(mTextSearch.getText().toString());
    }

    @Override
    public void clickItem(int position) {
        Toast.makeText(this, Constants.ENTERED + mUsers.get(position).getLogin(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUser(List<User> users) {
        mUsers.clear();
        mUsers.addAll(users);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
