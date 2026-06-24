package com.example.cashregister;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    HistoryAdapter adapter;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","History Activity - On Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","History Activity - On Restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","History Activity - On Stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","History Activity - On Start");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        Button btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        Toolbar toolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle("Assignment_2");

        }

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if (Data.history == null) {

            Data.history = new ArrayList<>();

        }

        adapter = new HistoryAdapter(Data.history);
        recyclerView.setAdapter(adapter);

    }

    @Override

    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged(); // ensures updates show when returning
    }
}
