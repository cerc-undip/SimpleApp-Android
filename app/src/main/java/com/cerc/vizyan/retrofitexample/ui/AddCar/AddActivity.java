package com.cerc.vizyan.retrofitexample.ui.AddCar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cerc.vizyan.retrofitexample.R;
import com.cerc.vizyan.retrofitexample.ui.Home.HomeActivity;

public class AddActivity extends AppCompatActivity implements AddView{

    private AddPresenter addPresenter;
    EditText etAddName, etAddMerk, etAddModel, etAddYear;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initPresenter();
        initView();

        addCar();
    }

    private void initView() {
        etAddName = findViewById(R.id.etAddName);
        etAddMerk = findViewById(R.id.etAddMerk);
        etAddModel = findViewById(R.id.etAddModel);
        etAddYear = findViewById(R.id.etAddYear);
        btnAdd = findViewById(R.id.btnAdd);
    }

    private void initPresenter() {
        addPresenter = new AddPresenter(this);
    }

    private void addCar() {
        btnAdd.setOnClickListener(v -> {
            addPresenter.addCar();
        });
    }

    @Override
    public String getName() {
        return etAddName.getText().toString();
    }

    @Override
    public String getMerk() {
        return etAddMerk.getText().toString();
    }

    @Override
    public String getModel() {
        return etAddModel.getText().toString();
    }

    @Override
    public String getYear() {
        return etAddYear.getText().toString();
    }

    @Override
    public void successAddCar() {
        Toast.makeText(this, "Berhasil Menambahkan Mobil", Toast.LENGTH_SHORT).show();
        Intent home = new Intent(AddActivity.this, HomeActivity.class);
        startActivity(home);
        finish();
    }

    @Override
    public void failedAddCar() {
        Toast.makeText(this, "Gagal Menambah Mobil", Toast.LENGTH_SHORT).show();
    }
}
