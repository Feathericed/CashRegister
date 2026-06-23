package com.example.cashregister;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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

    private char[] curChar= new char[]{'0'};
    private final CalcLogic calculator = new CalcLogic();
    private void checkDigitInput(char input){
        char lastChar;
        if(curChar.length>0){
            lastChar = curChar[curChar.length-1];

            if (lastChar>47 && lastChar <58 && input>47 && input <58){
                //if input is digit and last one was digit then overwrite the last char
                curChar[curChar.length-1]=input;
            }else if ((lastChar == 43 || lastChar == 45 ||lastChar == 47 || lastChar == 42)
                    && (input == 43 || input == 45 ||input == 47 || input == 42)){
                //overwrite the last char if the input and last char is operator
                curChar[curChar.length-1]=input;
            }else{
                //add a new chat into the array
                String myStr =new String(curChar) + String.valueOf(input);
                curChar= myStr.toCharArray();
            }
        }else{
            //add a new chat into the array
            String myStr =new String(curChar) + String.valueOf(input);
            curChar= myStr.toCharArray();
        }
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

        Button button_0 = findViewById(R.id.b0);
        Button button_1 = findViewById(R.id.b1);
        Button button_2 = findViewById(R.id.b2);
        Button button_3 = findViewById(R.id.b3);
        Button button_4 = findViewById(R.id.b4);
        Button button_5 = findViewById(R.id.b5);
        Button button_6 = findViewById(R.id.b6);
        Button button_7 = findViewById(R.id.b7);
        Button button_8 = findViewById(R.id.b8);
        Button button_9 = findViewById(R.id.b9);
        Button button_clear = findViewById(R.id.clear_button);
        Button button_enter = findViewById(R.id.buy_button);
        Button button_mode = findViewById(R.id.manager_button);
        //TextView history_field = findViewById(R.id.history_field);
        TextView calculate_field = findViewById(R.id.quantity);

        button_0.setOnClickListener(v -> {
            checkDigitInput('0');
            calculate_field.setText(new String(curChar));
        });
        button_1.setOnClickListener(v -> {
            checkDigitInput('1');
            calculate_field.setText(new String(curChar));
        });
        button_2.setOnClickListener(v -> {
            checkDigitInput('2');
            calculate_field.setText(new String(curChar));
        });
        button_3.setOnClickListener(v -> {
            checkDigitInput('3');
            calculate_field.setText(new String(curChar));
        });
        button_4.setOnClickListener(v -> {
            checkDigitInput('4');
            calculate_field.setText(new String(curChar));
        });
        button_5.setOnClickListener(v -> {
            checkDigitInput('5');
            calculate_field.setText(new String(curChar));
        });
        button_6.setOnClickListener(v -> {
            checkDigitInput('6');
            calculate_field.setText(new String(curChar));
        });
        button_7.setOnClickListener(v -> {
            checkDigitInput('7');
            calculate_field.setText(new String(curChar));
        });
        button_8.setOnClickListener(v -> {
            checkDigitInput('8');
            calculate_field.setText(new String(curChar));
        });
        button_9.setOnClickListener(v -> {
            checkDigitInput('9');
            calculate_field.setText(new String(curChar));
        });

        button_clear.setOnClickListener(v -> {
            //Button btn = (Button)v;
            curChar = new char[]{'0'};
            calculate_field.setText("0");
            Log.d("main active", "clear clicked" + v.toString());
        });
        button_enter.setOnClickListener(v -> {
            //push
            calculator.setLine(new String(curChar));
            Log.d("main active", "1");
            String display = new String(curChar) + " = " + Integer.toString(calculator.calculate());
            Log.d("main active", "2");
            calculator.push(display);
            Log.d("main active", "3");
            //clean up after push
            curChar = new char[]{'0'};
            calculate_field.setText(display);
        });

        button_mode.setOnClickListener(v -> {
            Intent goToHistoryIntent = new Intent(MainActivity.this,ManageActivity.class );
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}