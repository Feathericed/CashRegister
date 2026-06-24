package com.example.cashregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    Context context;
    List<Product> products;
    public ProductAdapter(Context context, List<Product> products){
        super(context,0,products);
        this.context=context;
        this.products=products;
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        if (converView == null) {
            converView = LayoutInflater.from(context)
                    .inflate(R.layout.listview_row, parent, false);
        }
        Product product = products.get(position);
        TextView tvName = converView.findViewById(R.id.prodName);
        TextView tvPrice = converView.findViewById(R.id.price);
        TextView tvQty = converView.findViewById(R.id.qty);
        tvName.setText(product.name);
        tvPrice.setText(Double.toString(product.price));
        tvQty.setText(Integer.toString(product.quantity));
        return converView;
    }


}
