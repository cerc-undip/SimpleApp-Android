package com.cerc.vizyan.retrofitexample.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataCar implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("merk")
    @Expose
    private String merk;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("year")
    @Expose
    private String year;

    protected DataCar(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        id = in.readInt();
        name = in.readString();
        merk = in.readString();
        model = in.readString();
        year = in.readString();
    }

    public static final Creator<DataCar> CREATOR = new Creator<DataCar>() {
        @Override
        public DataCar createFromParcel(Parcel in) {
            return new DataCar(in);
        }

        @Override
        public DataCar[] newArray(int size) {
            return new DataCar[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "DataUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", merk='" + merk + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(merk);
        dest.writeString(model);
        dest.writeString(year);
    }
}
