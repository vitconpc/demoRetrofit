package vn.com.example.demoretrofit.service.okhttp;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OKHttpHanlder extends AsyncTask<String, Void, byte[]> {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected byte[] doInBackground(String... strings) {

        Request.Builder builder = new Request.Builder();
        builder.url(strings[0]);
        Request request = builder.build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().bytes();
        } catch (IOException e) {
            return null;
        }
    }
}
