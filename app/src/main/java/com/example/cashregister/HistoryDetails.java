package com.example.cashregister;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class HistoryDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        Button btnBack = findViewById(R.id.btnBack);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Assignment_2 - Purchase Details");
        }

        Purchase purchase = getIntent().getParcelableExtra("purchase");

        TextView txtName = findViewById(R.id.txtName);
        TextView txtQty = findViewById(R.id.txtQty);
        TextView txtTotal = findViewById(R.id.txtTotal);
        TextView txtDate = findViewById(R.id.txtDate);

        if (purchase != null) {
            txtName.setText(getString(R.string.product_label, purchase.productName));
            txtQty.setText(getString(R.string.quantity_label, purchase.quantity));
            txtTotal.setText(getString(R.string.total_label, purchase.totalAmount));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            txtDate.setText(getString(R.string.date_label, sdf.format(purchase.purchaseDate)));
        }

        btnBack.setOnClickListener(v -> finish());
    }
}
