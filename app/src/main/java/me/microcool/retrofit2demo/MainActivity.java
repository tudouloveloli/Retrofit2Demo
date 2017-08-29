package me.microcool.retrofit2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

import me.microcool.retrofit2demo.retrofitcode.ApiStores;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        建议：
//               - Base URL: 总是以/结尾；- @Url: 不要以/开头
//               - Retrofit2 的baseUlr 必须以 /（斜线） 结束
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn/")
                .build();
        ApiStores apiStores = retrofit.create(ApiStores.class);
        Call<ResponseBody> call = apiStores.getWeather("101010100");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d(TAG, "Succeed" + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure! Messages:" + t.getMessage());
            }
        });
    }
}
