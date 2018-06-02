package com.cerc.vizyan.retrofitexample.ui.DetailCar;

import com.cerc.vizyan.retrofitexample.data.model.DataCar;

import java.util.List;

public interface DetailView {

    void successShowCar(List<DataCar> dataCars);

    void failedShowCar(String message);

    void successDeleteCar(String message);

    void failedDeleteCar(String message);

    void successPutCar(String message);

    void faildedPutCar(String message);

    String getName();

    String getMerk();

    String getModel();

    String getYear();

}
