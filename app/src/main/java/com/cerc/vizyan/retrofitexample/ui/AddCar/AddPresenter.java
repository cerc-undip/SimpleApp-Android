package com.cerc.vizyan.retrofitexample.ui.AddCar;

import android.util.Log;

import com.cerc.vizyan.retrofitexample.data.network.RetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPresenter {

    private AddView addView;

    public AddPresenter(AddView addView){
        this.addView = addView;
    }

    public void addCar(){
        final String tag = "Add-addCar";
        String name = addView.getName();
        String merk = addView.getMerk();
        String model = addView.getModel();
        String year = addView.getYear();

        RetrofitClient.getInstance()
                .getApi()
                .addCar(name, merk, model, year)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if(response.isSuccessful()){
                            addView.successAddCar();
                            Log.e(tag, response.body().toString());
                        } else {
                            addView.failedAddCar();
                            Log.e(tag, response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        addView.failedAddCar();
                        Log.e(tag, t.getMessage().toString());
                    }
                });
    }
}
