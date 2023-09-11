package com.example.assignment_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText editText_billValue;
        RadioGroup radioGroup_tipPercent;
        RadioButton radioButton_10, radioButton_15, radioButton_18, radioButton_custom;
        TextView view_customSlider, view_tipFinal, view_amountFinal;
        SeekBar seekBar_customTip;
        Button button_reset, button_calculate;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_billValue = findViewById(R.id.editText_billValue);
        radioGroup_tipPercent = findViewById(R.id.radioGroup_tipPercent);
        radioButton_10 = findViewById(R.id.radioButton_10);
        radioButton_15 = findViewById(R.id.radioButton_15);
        radioButton_18 = findViewById(R.id.radioButton_18);
        radioButton_custom = findViewById(R.id.radioButton_custom);
        view_customSlider = findViewById(R.id.view_customSlider);
        view_tipFinal = findViewById(R.id.view_tipFinal);
        view_amountFinal = findViewById(R.id.view_amountFinal);
        seekBar_customTip = findViewById(R.id.seekBar_customTip);
        button_reset = findViewById(R.id.button_reset);
        button_calculate = findViewById(R.id.button_calculate);

        findViewById(R.id.button_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredAmount = editText_billValue.getText().toString();
                if (enteredAmount.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter a valid bill value", Toast.LENGTH_SHORT);
                }
                try{
                    double billAmount = Double.valueOf(enteredAmount);
                    Bill bill = new Bill();
                } catch(NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Enter a valid bill value", Toast.LENGTH_SHORT);
                }
            }

//  Double.parseDouble();
        });
    }
}