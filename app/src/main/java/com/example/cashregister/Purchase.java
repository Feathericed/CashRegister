package com.example.cashregister;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Date;

public class Purchase implements Parcelable {
    final String productName;
    final int quantity;
    final double totalAmount;
    final Date purchaseDate;

    public Purchase(String name, int quantity, double totalAmount, Date now) {
        this.productName = name;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.purchaseDate = now;
    }

    protected Purchase(Parcel in) {
        productName = in.readString();
        quantity = in.readInt();
        totalAmount = in.readDouble();
        long time = in.readLong();
        purchaseDate = new Date(time);
    }

    public static final Creator<Purchase> CREATOR = new Creator<>() {
        @Override
        public Purchase createFromParcel(Parcel in) {
            return new Purchase(in);
        }

        @Override
        public Purchase[] newArray(int size) {
            return new Purchase[size];
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
        dest.writeLong(purchaseDate.getTime());
    }
}
