package com.cerc.vizyan.retrofitexample.data.network;

import com.cerc.vizyan.retrofitexample.utility.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient retrofitClient;

    private RetrofitClient(){}

    public static RetrofitClient getInstance(){
        if(retrofitClient == null){
            retrofitClient = new RetrofitClient();
        }

        return retrofitClient;
    }

    public Api getApi(){
        return getRetrofit().create(Api.class);
    }

    public Retrofit getRetrofit(){

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
