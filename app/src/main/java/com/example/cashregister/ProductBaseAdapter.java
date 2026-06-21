package com.example.cashregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductBaseAdapter extends BaseAdapter {

    ArrayList<Product> list;
    Context context;

    public ProductBaseAdapter(ArrayList<Product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row_view = LayoutInflater.from(context).inflate(R.layout.listview_row, parent,false);
        TextView name_text = row_view.findViewById(R.id.std_list_stdName);
        TextView quantity = row_view.findViewById(R.id.quantity);
        TextView price = row_view.findViewById(R.id.std_list_collegeName);

        name_text.setText(list.get(position).name);
        quantity.setText(""+list.get(position).quantity);
        price.setText(""+list.get(position).price);

        return row_view;
    }
}
