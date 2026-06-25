package com.example.cashregister;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Purchase> history = new ArrayList<>();
    public static final ArrayList<Product> products = new ArrayList<>();

    static {

        // initialize default products
        products.add(new Product("Pants", 10, 20.44));
        products.add(new Product("Shoes", 100, 10.44));
        products.add(new Product("Hats", 30, 5.90));
    }

}
