package vn.com.example.demoretrofit.data.datasource.remote;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.concurrent.ExecutionException;

import vn.com.example.demoretrofit.common.Constants;
import vn.com.example.demoretrofit.data.datasource.DataSource;
import vn.com.example.demoretrofit.service.okhttp.OKHttpHanlder;

public class GetImageRemoteDatasource implements DataSource.RemoteDataSource {

    private static final String URL = "http://i2.kym-cdn.com/photos/images/newsfeed/000/101/781/Y0UJC.png";
    private static GetImageRemoteDatasource sGetImageRemoteDatasource;

    public GetImageRemoteDatasource() {
    }

    public static GetImageRemoteDatasource getInstance() {
        if (sGetImageRemoteDatasource == null) {
            sGetImageRemoteDatasource = new GetImageRemoteDatasource();
        }
        return sGetImageRemoteDatasource;
    }

    @Override
    public void searchUserbyName(String key, DataSource.OnFetchDataListener listener) {

    }

    @Override
    public void getImage(DataSource.OnGetImageListener listener) {
        OKHttpHanlder hanlder = new OKHttpHanlder();
        byte image[];
        try {
            image = hanlder.execute(URL).get();
            if (image != null && image.length > 0) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                listener.onGetImageSuccess(bitmap);
            } else {
                listener.onGetImageError(Constants.ERROR_LINK);
            }
        } catch (InterruptedException e) {
            listener.onGetImageError(Constants.INTERRRUPTED);
        } catch (ExecutionException e) {
            listener.onGetImageError(Constants.EXECUTION);
        }
    }
}
