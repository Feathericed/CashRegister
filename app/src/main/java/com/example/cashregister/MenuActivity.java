package com.example.cashregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Objects;

public class MenuActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        Button btnHistory = findViewById(R.id.btnHistory);
        Button btnRestock = findViewById(R.id.btnRestock);
        Button btnBack = findViewById(R.id.btnBack);

        Toolbar toolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Assignment_2");
        }

        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(this, HistoryActivity.class);
            startActivity(intent);
        });

        btnRestock.setOnClickListener(v -> {
            Intent intent = new Intent(this, RestockActivity.class);
            startActivity(intent);
        });

        btnBack.setOnClickListener(v -> finish());

    }

}