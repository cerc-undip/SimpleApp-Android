package com.cerc.vizyan.retrofitexample.ui.DetailCar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cerc.vizyan.retrofitexample.R;
import com.cerc.vizyan.retrofitexample.data.model.DataCar;
import com.cerc.vizyan.retrofitexample.ui.Home.HomeActivity;
import com.cerc.vizyan.retrofitexample.utility.Constant;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private DetailPresenter detailPresenter;
    private DataCar dataCar;
    Button btnUpdate, btnDelete;
    EditText etName, etMerk, etModel, etYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initPresenter();
        initView();
        initDataIntent();
        initDataPresenter();

        delete();
        update();
    }

    private void initPresenter() {
        detailPresenter = new DetailPresenter(this);
    }

    private void initView() {
        etName = findViewById(R.id.etName);
        etMerk = findViewById(R.id.etMerk);
        etModel = findViewById(R.id.etModel);
        etYear = findViewById(R.id.etYear);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
    }

    private void initDataIntent() {
        dataCar = getIntent().getParcelableExtra(Constant.Extra.DATA);
        if (dataCar == null) finish();
    }

    private void initDataPresenter() {
        detailPresenter.getCarById(dataCar.getId());
    }

    private void delete() {
        btnDelete.setOnClickListener(v -> {
            detailPresenter.deleteCar(dataCar.getId());
        });
    }

    private void update() {
        btnUpdate.setOnClickListener(v -> {
            detailPresenter.putCar(dataCar.getId());
        });
    }

    @Override
    public void successShowCar(List<DataCar> dataCars) {
        this.dataCar = dataCars.get(0);
        etName.setText(dataCar.getName());
        etMerk.setText(dataCar.getMerk());
        etModel.setText(dataCar.getModel());
        etYear.setText(dataCar.getYear());
    }

    @Override
    public void failedShowCar(String message) {
        Toast.makeText(this, "Maaf terjadi kesalahan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successDeleteCar(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent home = new Intent(DetailActivity.this, HomeActivity.class);
        startActivity(home);
        finish();
    }

    @Override
    public void failedDeleteCar(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successPutCar(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void faildedPutCar(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public String getMerk() {
        return etMerk.getText().toString();
    }

    @Override
    public String getModel() {
        return etModel.getText().toString();
    }

    @Override
    public String getYear() {
        return etYear.getText().toString();
    }
}
