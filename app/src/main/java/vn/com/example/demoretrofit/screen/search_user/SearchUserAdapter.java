package vn.com.example.demoretrofit.screen.search_user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.com.example.demoretrofit.R;
import vn.com.example.demoretrofit.data.model.User;

public class SearchUserAdapter extends RecyclerView.Adapter<SearchUserAdapter.UserViewHolder> {
    private Context mContext;
    private List<User> mUsers;
    private OnClickRecycler mOnclOnClickRecycler;

    public SearchUserAdapter(Context mContext, List<User> mUsers, OnClickRecycler mOnclOnClickRecycler) {
        this.mContext = mContext;
        this.mUsers = mUsers;
        this.mOnclOnClickRecycler = mOnclOnClickRecycler;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindData(mUsers.get(position));

    }

    @Override
    public int getItemCount() {
        return mUsers == null ? 0 : mUsers.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mImageAvatar;
        private TextView mTextLogin;
        private TextView mTextSource;

        public UserViewHolder(View itemView) {
            super(itemView);
            initView(itemView);
            itemView.setOnClickListener(this);
        }

        private void initView(View itemView) {
            mImageAvatar = itemView.findViewById(R.id.image_user);
            mTextLogin = itemView.findViewById(R.id.text_login);
            mTextSource = itemView.findViewById(R.id.text_score);
        }

        public void bindData(User user) {
            mTextLogin.setText(user.getLogin());
            mTextSource.setText(user.getScore() + "");
            Glide.with(mContext).load(user.getAvatarUrl()).into(mImageAvatar);
        }

        @Override
        public void onClick(View v) {
            mOnclOnClickRecycler.clickItem(getAdapterPosition());
        }
    }
}
