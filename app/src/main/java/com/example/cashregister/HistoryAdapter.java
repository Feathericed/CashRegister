package com.example.cashregister;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    public HistoryAdapter(List<Purchase> list) {
        list = Data.history;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, qty, total;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.prodName);
            qty = itemView.findViewById(R.id.qty);
            total = itemView.findViewById(R.id.total);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Purchase p = Data.history.get(position);

        holder.name.setText(p.productName);
        holder.qty.setText("Qty: " + p.quantity);
        holder.total.setText("$" + p.totalAmount);
    }

    @Override
    public int getItemCount() {
        return Data.history.size();
    }
}