package vn.com.example.demoretrofit.screen.show_image;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import vn.com.example.demoretrofit.R;

public class ShowImageActivity extends AppCompatActivity implements ShowImageContact.View, View.OnClickListener {

    private ImageView mImageOnline;
    private ShowImageContact.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        initView();
    }

    private void initView() {
        mImageOnline = findViewById(R.id.image_online);
        findViewById(R.id.button_get_image).setOnClickListener(this);
        mPresenter = new ShowImagePresenter(this);
    }

    @Override
    public void showImage(Bitmap bitmap) {
        mImageOnline.setImageBitmap(bitmap);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mPresenter.getImage();
    }
}
