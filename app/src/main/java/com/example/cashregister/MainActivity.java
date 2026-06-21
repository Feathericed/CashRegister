package com.example.cashregister;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText std_name_text;
    ListView std_table;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","Main Activity - On Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","Main Activity - On Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","Main Activity - On Restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","Main Activity - On Stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","Main Activity - On Start");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","Main Activity - On Create");

        String[] listOfProducts = new String[]{
                "Jeans",
                "Baseball Cap",
                "T-Shirt",
                "Pair of Socks",
                "Sweater",
                "Sweatshirt",
                "Pants",
                "Jacket"
        };

        Integer[] listOfQuantities = new Integer[]{
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10
        };

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}