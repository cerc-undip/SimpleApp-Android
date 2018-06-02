package com.cerc.vizyan.retrofitexample.ui.DetailCar;

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

public class DetailPresenter {

    private DetailView detailView;

    public DetailPresenter(DetailView detailView){
        this.detailView = detailView;
    }

    public void getCarById(int id){
        final String tag = "Detail-getCar";
        RetrofitClient.getInstance()
                .getApi()
                .GetCarById(id)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            JsonObject body = response.body();
                            JsonArray array = body.get("result").getAsJsonArray();
                            Type type = new TypeToken<List<DataCar>>(){}.getType();
                            List<DataCar> dataCars = new Gson().fromJson(array, type);
                            detailView.successShowCar(dataCars);
                            Log.e(tag, response.body().toString());
                        } else {
                            detailView.failedShowCar("Maaf terjadi kesalahan");
                            Log.e(tag, response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        detailView.failedShowCar("Maaf terjadi kesalahan");
                        Log.e(tag, t.getMessage().toString());
                    }
                });
    }

    public void putCar(int id){
        final String tag = "Home-putCar";
        String name = detailView.getName();
        String merk = detailView.getMerk();
        String model = detailView.getModel();
        String year = detailView.getYear();

        RetrofitClient.getInstance()
                .getApi()
                .putCar(id, name, merk, model, year)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            detailView.successPutCar("Berhasil Menyimpan Perubahan");
                            Log.e(tag, response.body().toString());
                        } else {
                            detailView.faildedPutCar("Gagal Menyimpan Perubahan");
                            Log.e(tag, response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        detailView.faildedPutCar("Gagal Menyimpan Perubahan");
                        Log.e(tag, t.getMessage().toString());
                    }
                });
    }

    public void deleteCar(int id){
        final String tag = "Detail-delete";

        RetrofitClient.getInstance()
                .getApi()
                .deleteCar(id)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            detailView.successDeleteCar("Berhasil Menghapus Mobil");
                            Log.d(tag, response.body().toString());
                        } else {
                            detailView.failedDeleteCar("Gagal Menghapus Mobil");
                            Log.d(tag, response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        detailView.failedDeleteCar("Gagal Menghapus Mobil");
                        Log.d(tag, t.getMessage().toString());
                    }
                });
    }
}
