package vn.com.example.demoretrofit.data.datasource;

import android.graphics.Bitmap;

import java.util.List;

public interface DataSource {
    interface RemoteDataSource {
        void searchUserbyName(String key, OnFetchDataListener listener);

        void getImage(OnGetImageListener listener);
    }

    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> datas);

        void onFetchDataError(String error);
    }

    interface OnGetImageListener {
        void onGetImageSuccess(Bitmap bitmap);

        void onGetImageError(String error);
    }
}
