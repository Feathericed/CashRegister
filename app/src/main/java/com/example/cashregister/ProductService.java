package com.example.cashregister;

import java.util.ArrayList;

public class ProductService {
    public ProductService() {
        this.list = new ArrayList<Product>();
    }

    static ProductService shared = new ProductService();
    ArrayList<Product> list;

    void saveNewStudent(Product std){
        list.add(std);
    }

    void saveNewStudent(String name, int quantity, double totalAmount){
        list.add(new Product(name,quantity,totalAmount));
    }
}


