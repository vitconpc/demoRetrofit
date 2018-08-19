package vn.com.example.demoretrofit.screen.show_image;

import android.graphics.Bitmap;

import vn.com.example.demoretrofit.data.datasource.DataSource;
import vn.com.example.demoretrofit.data.reponsitory.ImageReponsitory;

public class ShowImagePresenter implements ShowImageContact.Presenter,DataSource.OnGetImageListener {

    private ShowImageContact.View mView;
    private ImageReponsitory mImageReponsitory;

    public ShowImagePresenter(ShowImageContact.View mView) {
        this.mView = mView;
        this.mImageReponsitory = ImageReponsitory.getInstance();
    }

    @Override
    public void getImage() {
        mImageReponsitory.getImage(this);
    }

    @Override
    public void onGetImageSuccess(Bitmap bitmap) {
        mView.showImage(bitmap);
    }

    @Override
    public void onGetImageError(String error) {
        mView.showError(error);
    }
}
