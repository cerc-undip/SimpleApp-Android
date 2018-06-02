package com.cerc.vizyan.retrofitexample.ui.Home;

import com.cerc.vizyan.retrofitexample.data.model.DataCar;

import java.util.List;

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);

    void failedShowCar(String message);
}
