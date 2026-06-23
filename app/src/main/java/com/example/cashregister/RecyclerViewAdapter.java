package com.example.cashregister;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<RecyclerViewAdapter.PurchaseHolder>{


    interface TaskUpdatingListener {
        void taskUpdated(int position);
    }

    TaskUpdatingListener listener;
    ArrayList<Purchase> purchaseList;
    //Context context;

    public RecyclerViewAdapter(ArrayList<Purchase> todoList) {
        this.purchaseList = todoList;
    }



    // inner class
    static class PurchaseHolder extends RecyclerView.ViewHolder{
        private final TextView productName;
        private final TextView purchaseDate;
        private final TextView purchaseQuantity;
        private final TextView purchaseAmount;
        public PurchaseHolder(@NonNull View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.purchaseName);
            purchaseDate = (TextView) view.findViewById(R.id.purchaseDate);
            purchaseQuantity = (TextView) view.findViewById(R.id.purchaseQuantity);
            purchaseAmount = (TextView) view.findViewById(R.id.totalAmount);
        }
        public TextView getProductName() {
            return productName;
        }

        public TextView getPurchaseDate() {
            return purchaseDate;
        }

        public TextView getPurchaseAmount() {
            return purchaseAmount;
        }
    }


    @NonNull
    @Override
    public PurchaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_row,parent,false);
        return new PurchaseHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseHolder holder, int position) {
        Purchase item = purchaseList.get(position);
        holder.productName.setText(item.productName);
        holder.purchaseDate.setText(item.purchaseDate.toString());
        holder.purchaseQuantity.setText("" + item.quantity);
        holder.purchaseAmount.setText("" + item.totalAmount);
    }


    @Override
    public int getItemCount() {
        return purchaseList.size();
    }// 10
}
