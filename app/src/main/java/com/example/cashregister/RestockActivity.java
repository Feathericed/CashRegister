package com.example.cashregister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;


public class RestockActivity extends AppCompatActivity {

    private EditText edtQuantity;

    private int selectedIndex = -1;

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("lifecycle","Restock Activity  - On Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","Restock Activity - On Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","Restock Activity - On Restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","Restock Activity - On Stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","Restock Activity - On Start");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewRestock);
        edtQuantity = findViewById(R.id.edtQuantity);

        Button btnOk = findViewById(R.id.btnOk);

        Button btnCancel = findViewById(R.id.btnCancel);

        Toolbar toolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Assignment_2");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        RestockAdapter adapter = new RestockAdapter(position -> {
            selectedIndex = position;
        });

        recyclerView.setAdapter(adapter);

        btnOk.setOnClickListener(v -> {
            if (selectedIndex == -1) {
                Toast.makeText(this, "Select a product", Toast.LENGTH_SHORT).show();
                return;
            }

            String input = edtQuantity.getText().toString().trim();

            if (input.isEmpty()) {
                edtQuantity.setError("Enter quantity");
                return;
            }

            int addQty;

            try {
                addQty = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                edtQuantity.setError("Invalid number");
                return;
            }

            Product p = Data.products.get(selectedIndex);
            p.setQuantity(p.getQuantity() + addQty);
            for (int i = 0; i < Data.products.size(); i++) {

                if (Objects.equals(Data.products.get(i).getName(), p.getName())) {
                    Data.products.set(i, p);
                    break;
                }
            }
            Toast.makeText(this, "Restocked " + p.getName(), Toast.LENGTH_SHORT).show();

            finish();

        });
        btnCancel.setOnClickListener(v -> finish());
    }
}