package com.cerc.vizyan.retrofitexample.ui.AddCar;

public interface AddView {
    String getName();

    String getMerk();

    String getModel();

    String getYear();

    void successAddCar();

    void failedAddCar();
}
