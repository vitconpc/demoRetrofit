package vn.com.example.demoretrofit.screen.show_image;

import android.graphics.Bitmap;

public interface ShowImageContact {
    interface View{
        void showImage(Bitmap bitmap);
        void showError(String error);
    }

    interface Presenter{
        void getImage();
    }
}
