package com.example.cashregister;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class Purchase implements Parcelable {
    String productName;
    int quantity;
    double totalAmount;
    String purchaseDate;

    public Purchase(String name, int quantity, double totalAmount) {
        this.productName = name;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        this.purchaseDate = dateFormat.format(new Date());
    }

    protected Purchase(Parcel in) {
        productName = in.readString();
        quantity = in.readInt();
        totalAmount = in.readDouble();
        purchaseDate = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
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
        dest.writeString(productName);
        dest.writeInt(quantity);
        dest.writeDouble(totalAmount);
        dest.writeString(purchaseDate);
    }
}
