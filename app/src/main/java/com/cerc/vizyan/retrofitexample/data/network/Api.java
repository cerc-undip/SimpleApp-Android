package com.cerc.vizyan.retrofitexample.data.network;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.*;

public interface Api {

    @Headers("Content-Type: application/json")

    @GET("getAllCar.php")
    Call<JsonObject> getAllCar();

    @GET("getCarById.php")
    Call<JsonObject> GetCarById(
            @Query("id") int id
    );

    @FormUrlEncoded
    @POST("addCar.php")
    Call<JsonObject> addCar(
            @Field("name") String name,
            @Field("merk") String merk,
            @Field("model") String model,
            @Field("year") String year
    );

    @FormUrlEncoded
    @POST("putCar.php")
    Call<JsonObject> putCar(
            @Field("id") int id,
            @Field("name") String name,
            @Field("merk") String merk,
            @Field("model") String model,
            @Field("year") String year
    );

    @GET("deleteCar.php")
    Call<JsonObject> deleteCar(
            @Query("id") int id
    );

}
