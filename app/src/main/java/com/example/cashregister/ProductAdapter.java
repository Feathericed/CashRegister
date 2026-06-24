package com.example.cashregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    Context context;
    List<Product> products;
    public ProductAdapter(Context context, List<Product> products){
        super(context,0,products);
        this.context=context;
        this.products=products;
    }

    static class ViewHolder {
        TextView name, price, qty;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.listview_row, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.prodName);
            holder.price = convertView.findViewById(R.id.price);
            holder.qty = convertView.findViewById(R.id.qty);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Product product = products.get(position);

        holder.name.setText(product.name);
        holder.qty.setText(
                convertView.getContext()
                        .getString(R.string.quantity_label, product.getQuantity())
        );
        holder.price.setText(
                convertView.getContext()
                        .getString(R.string.price_label, product.getPrice())
        );
        return convertView;
    }
}
