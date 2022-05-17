package com.example.myapplication;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Attribute;

    Button deposit_btn;
    TextView account_value;
    TextView account_value2;

    Spinner currency_spr;
    Button Withdraw_btn;
    Deposit Deposit = new Deposit();
    Withdraw Withdraw = new Withdraw();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        account_value = (TextView) findViewById(R.id.account_display);
        deposit_btn = (Button) findViewById(R.id.button);
        Withdraw_btn = (Button) findViewById(R.id.button2);
        account_value2 = (TextView) findViewById(R.id.account_label1);
        currency_spr = (Spinner) findViewById(R.id.currency_spinner);


        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.currency_array, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency_spr.setAdapter(dataAdapter);

        currency_spr.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String Me = adapterView.getSelectedItem().toString();
                account_value2.setText(String.valueOf(Integer.parseInt(account_value2.getText().toString()) + Me));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        Withdraw_btn.setOnClickListener(new OnClickListener() {





            @Override
            public void onClick(View view) {
               // account_value.setText(String.valueOf(Integer.parseInt(account_value.getText().toString()) - 1000));
                //account_value2.setText(String.valueOf(Integer.parseInt(account_value2.getText().toString()) + 1000));
                account_value.setText(String.valueOf(Integer.parseInt(account_value.getText().toString()) - Withdraw.getCount()));
                account_value2.setText(String.valueOf(Integer.parseInt(account_value2.getText().toString()) + Withdraw.getCount()));




                account_value2.setText(String.valueOf(Integer.parseInt(account_value2.getText().toString())));



            }
        });





        deposit_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                account_value.setText(String.valueOf(Integer.parseInt(account_value.getText().toString()) + Deposit.getCount()));
                account_value2.setText(String.valueOf(Integer.parseInt(account_value2.getText().toString()) - Deposit.getCount()));

              //  account_value.setText(String.valueOf(Integer.parseInt(account_value.getText().toString()) + 1000));
             //   account_value2.setText(String.valueOf(Integer.parseInt(account_value2.getText().toString()) - 1000));

            }
        });
    }
}

//currency_spr.setAdapter(dataAdapter);
