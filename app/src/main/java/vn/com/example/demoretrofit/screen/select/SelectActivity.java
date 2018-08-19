package vn.com.example.demoretrofit.screen.select;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import vn.com.example.demoretrofit.R;
import vn.com.example.demoretrofit.screen.search_user.SearchUserActivity;
import vn.com.example.demoretrofit.screen.show_image.ShowImageActivity;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        initView();
    }

    private void initView() {
        findViewById(R.id.button_get_image).setOnClickListener(this);
        findViewById(R.id.button_search).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_get_image: {
                Intent intent = new Intent(this, ShowImageActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.button_search: {
                Intent intent = new Intent(this, SearchUserActivity.class);
                startActivity(intent);
            }
            break;
        }
    }
}
