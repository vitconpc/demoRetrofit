package vn.com.example.demoretrofit.data.reponsitory;

import vn.com.example.demoretrofit.data.datasource.DataSource;
import vn.com.example.demoretrofit.data.datasource.remote.GetImageRemoteDatasource;

public class ImageReponsitory {
    private static ImageReponsitory sImageReponsitory;
    private DataSource.RemoteDataSource mRemoteDataSource;

    public ImageReponsitory(DataSource.RemoteDataSource mRemoteDataSource) {
        this.mRemoteDataSource = mRemoteDataSource;
    }

    public static ImageReponsitory getInstance() {
        if (sImageReponsitory == null) {
            sImageReponsitory = new ImageReponsitory(GetImageRemoteDatasource.getInstance());
        }
        return sImageReponsitory;
    }

    public void getImage(DataSource.OnGetImageListener listener) {
        mRemoteDataSource.getImage(listener);
    }
}
