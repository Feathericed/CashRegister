package com.example.cashregister;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    final List<Purchase> list;
    private final OnItemClickListener listener;

    public HistoryAdapter(List<Purchase> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name, qty, total;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.prodName_hist);
            qty = itemView.findViewById(R.id.qty_hist);
            total = itemView.findViewById(R.id.total_hist);
        }
    }


    public interface OnItemClickListener {
        void onItemClick(Purchase history);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_history, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Purchase p = list.get(position);

        holder.name.setText(p.productName);
        holder.qty.setText(String.format("%s", p.quantity));
        holder.total.setText(String.format("%s", p.totalAmount));

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(p);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}