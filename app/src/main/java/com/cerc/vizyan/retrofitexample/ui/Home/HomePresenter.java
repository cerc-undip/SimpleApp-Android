package com.cerc.vizyan.retrofitexample.ui.Home;

import android.util.Log;

import com.cerc.vizyan.retrofitexample.data.model.DataCar;
import com.cerc.vizyan.retrofitexample.data.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

    private HomeView homeView;

    public HomePresenter (HomeView homeView){
        this.homeView = homeView;
    }

    public void getAllCar(){
        final String tag = "Home-getAllCar";
        RetrofitClient.getInstance()
                .getApi()
                .getAllCar()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            JsonObject body = response.body();
                            JsonArray array = body.get("result").getAsJsonArray();
                            Type type = new TypeToken<List<DataCar>>(){}.getType();
                            List<DataCar> dataCars = new Gson().fromJson(array, type);
                            homeView.successShowCar(dataCars);
                            Log.e(tag, response.body().toString());
                        } else {
                            homeView.failedShowCar("Maaf terjadi kesalahan");
                            Log.e(tag, response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        homeView.failedShowCar("Maaf terjadi kesalahan");
                        Log.d(tag, t.getMessage().toString());
                    }
                });
    }
}
