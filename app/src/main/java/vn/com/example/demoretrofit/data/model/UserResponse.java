package vn.com.example.demoretrofit.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("total_count")
    @Expose
    private int mTotalCount;
    @SerializedName("incomplete_results")
    @Expose
    private boolean mIncompleteResults;
    @SerializedName("items")
    @Expose
    private List<User> mUsers = null;

    public UserResponse() {
    }

    public Integer getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.mTotalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return mIncompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.mIncompleteResults = incompleteResults;
    }

    public List<User> getUsers() {
        return mUsers;
    }

    public void setUsers(List<User> users) {
        this.mUsers = users;
    }
}
