package com.example.cashregister;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {

    final String name;
    int quantity;
    final double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    protected Product(Parcel in) {
        name = in.readString();
        quantity = in.readInt();
        price = in.readDouble();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //public void setName(String name) {this.name = name;};
    //public void setPrice(double price) {this.price = price;};

    public static final Creator<Product> CREATOR = new Creator<>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(quantity);
        dest.writeDouble(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
