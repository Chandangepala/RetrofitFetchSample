package com.basic.retrofitsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.basic.retrofitsample.retrofit.model.NewsResponse;
import com.basic.retrofitsample.retrofit.utils.ApiClient;
import com.basic.retrofitsample.retrofit.utils.ApiService;
import com.google.gson.JsonArray;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new ApiClient().getRetrofit();
        ApiService apiService  = retrofit.create(ApiService.class);
        Call<NewsResponse> newsCall = apiService.getNewsResponse();
        newsCall.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                Log.d("NewsResponse::", response + "");
                Log.d("status", response.body().status);
                Log.d("totalResults", response.body().totalResults);
                JsonArray jsonArray = response.body().articles;
                for (int i= 0; i < jsonArray.size(); i++){
                    String title = jsonArray.get(i).getAsJsonObject().get("title").getAsString();
                    Log.e("NewsAPI_title", title);
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("onFailure::NewsResponse", t.getMessage());
            }
        });
    }
}