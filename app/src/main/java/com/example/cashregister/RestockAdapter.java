package com.example.cashregister;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class RestockAdapter extends RecyclerView.Adapter<RestockAdapter.ViewHolder> {

    private int selectedPosition = -1;

    private final OnItemClickListener listener;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, qty, price;
        public View layout;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            name = itemView.findViewById(R.id.prodRestName);
            qty = itemView.findViewById(R.id.qtyRest);
            price = itemView.findViewById(R.id.priceRest);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public RestockAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_restock, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Product p = Data.products.get(position);
        holder.name.setText(p.getName());
        holder.qty.setText(
                holder.itemView.getContext()
                        .getString(R.string.quantity_label, p.getQuantity())
        );
        holder.price.setText(
                holder.itemView.getContext()
                        .getString(R.string.price_label, p.getPrice())
        );

        holder.itemView.setAlpha(selectedPosition == position ? 1.0f : 0.6f);

        holder.itemView.setOnClickListener(v -> {
            int pos = holder.getAdapterPosition();
            if (pos == RecyclerView.NO_POSITION) return;

            int oldPos = selectedPosition;
            selectedPosition = pos;

            if (listener != null) {
                listener.onItemClick(pos);
            }

            notifyItemChanged(oldPos);
            notifyItemChanged(pos);
        });
    }

    @Override
    public int getItemCount() {
        return Data.products.size();
    }
}