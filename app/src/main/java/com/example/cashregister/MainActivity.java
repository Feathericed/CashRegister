package com.example.cashregister;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private char[] curChar= new char[]{'0'};
    private void checkDigitInput(char input){
        char lastChar;
        if(curChar.length>0){
            lastChar = curChar[curChar.length-1];
            if (curChar.length==1 && lastChar =='0'){
                //overwrite
                curChar[curChar.length-1]=input;
            }else{
                String myStr =new String(curChar) + input;
                curChar= myStr.toCharArray();
            }


        }else{
            //add a new chat into the array
            String myStr =new String(curChar) + input;
            curChar= myStr.toCharArray();
        }
    }
    boolean checkProdValid(TextView product, TextView calculate_field){
        String s = product.getText().toString();
        boolean rtn= "Pants".equals(s) || "Shoes".equals(s) || "Hats".equals(s);
        if (rtn){
            calculate_field.setText(new String(curChar));
            TextView total = findViewById(R.id.total);
            int c=Integer.parseInt( new String(curChar));
            for (Product item: Data.products){
                if(item.name.equals(s)){
                    if(item.quantity<c) {
                        Toast.makeText(this,"No enough quantity in the stock!!!" , Toast.LENGTH_SHORT).show();
                        total.setText(R.string.total);
                        break;
                    }
                    DecimalFormat df = new DecimalFormat("0.00");
                    total.setText(df.format( c * item.price));
                    break;
                }

            }
        }
        else{
            Toast.makeText(this,"Please select product", Toast.LENGTH_SHORT).show();
            curChar= new char[]{'0'};
        }
        return rtn;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","Main Activity - On Create");

        ListView lv = findViewById(R.id.list);

        ProductAdapter adapter= new ProductAdapter(this, Data.products);

        lv.setAdapter(adapter);

        refresh();

        Toolbar toolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Assignment_2");
        }

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
        TextView calculate_field = findViewById(R.id.quantity);
        TextView product = findViewById(R.id.selected_product);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            // Get the clicked item string based on its position index
            try {
                Toast.makeText(MainActivity.this, "You clicked: " + position, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "You clicked: " + id, Toast.LENGTH_SHORT).show();
                product.setText(Data.products.get(position).name);
                // Display a quick alert pop-up message (Toast)
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "You clicked: " + e, Toast.LENGTH_LONG).show();
            }
            });
        button_enter.setOnClickListener(v -> {
            String s = product.getText().toString();
            TextView total = findViewById(R.id.total);
            String t = total.getText().toString();
            if(!("Pants".equals(s) || "Shoes".equals(s) || "Hats".equals(s))|| t.equals("Total")){
                Toast.makeText(MainActivity.this, "All fields are required!!!", Toast.LENGTH_SHORT).show();
            } else if (calculate_field.getText().equals("")) {
                Toast.makeText(MainActivity.this, "All fields are required!!!", Toast.LENGTH_SHORT).show();
            } else {
                String name = product.getText().toString();
                String qty = calculate_field.getText().toString();
                String tt = total.getText().toString();
                new AlertDialog.Builder(this).setTitle("Thank you for your purchase")
                        .setMessage("Your purchase is "+qty+" "+ name +" for "+ tt)
                        .setPositiveButton("OK",null)
                        .show();
                for (Product item: Data.products){
                    if(item.name.equals(name)){
                        item.quantity= item.quantity-Integer.parseInt(qty);
                        refresh();
                        Calendar calendar = Calendar.getInstance();
                        Date now = calendar.getTime();
                        item.setQuantity(item.quantity);
                        Data.history.add(new Purchase(name, Integer.parseInt(qty), Double.parseDouble(tt), now));
                        break;
                    }
                }
            }
        });
        button_0.setOnClickListener(v -> {
            checkDigitInput('0');
            checkProdValid(product,calculate_field);
        });
        button_1.setOnClickListener(v -> {
            checkDigitInput('1');
            checkProdValid(product,calculate_field);
        });
        button_2.setOnClickListener(v -> {
            checkDigitInput('2');
            checkProdValid(product,calculate_field);
        });
        button_3.setOnClickListener(v -> {
            checkDigitInput('3');
            checkProdValid(product,calculate_field);
        });
        button_4.setOnClickListener(v -> {
            checkDigitInput('4');
            checkProdValid(product,calculate_field);
        });
        button_5.setOnClickListener(v -> {
            checkDigitInput('5');
            checkProdValid(product,calculate_field);
        });
        button_6.setOnClickListener(v -> {
            checkDigitInput('6');
            checkProdValid(product,calculate_field);
        });
        button_7.setOnClickListener(v -> {
            checkDigitInput('7');
            checkProdValid(product,calculate_field);
        });
        button_8.setOnClickListener(v -> {
            checkDigitInput('8');
            checkProdValid(product,calculate_field);
        });
        button_9.setOnClickListener(v -> {
            checkDigitInput('9');
            checkProdValid(product,calculate_field);
        });

        button_clear.setOnClickListener(v -> {
            //Button btn = (Button)v;
            curChar = new char[]{'0'};
            calculate_field.setText("0");
            Log.d("main active", "clear clicked" + v.toString());
        });

        button_mode.setOnClickListener(v -> {
            Intent gotoHistory = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(gotoHistory);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
        Log.d("lifecycle","Main Activity - On Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        refresh();
        Log.d("lifecycle","Main Activity - On Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        refresh();
        Log.d("lifecycle","Main Activity - On Restart");
    }

    @Override
    protected void onStop() {
        refresh();
        super.onStop();
        Log.d("lifecycle","Main Activity - On Stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","Main Activity - On Start");
    }

    protected void refresh () {
        ListView lv = findViewById(R.id.list);

        ProductAdapter adapter= new ProductAdapter(this, Data.products);

        lv.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        TextView calculate_field = findViewById(R.id.quantity);
        TextView total = findViewById(R.id.total);
        TextView product = findViewById(R.id.selected_product);

        product.setText("");
        calculate_field.setText("");
        total.setText("");
    }
}