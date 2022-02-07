package com.vpn.task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radiobutton, radiobutton1;
    Button plus, minus;
    ImageButton reset;

    TextView counter;
    Counter count = new Counter(-100, 100, 1, 7);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radiogroup);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        reset = (ImageButton) findViewById(R.id.reset);
        counter = findViewById(R.id.counter);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setText(count.plus(Integer.parseInt(counter.getText().toString())) + "");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setText(count.minus(Integer.parseInt(counter.getText().toString())) + "");
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setText(count.reset() + "");
            }
        });
    }

    public void checkButton(View v) {
        radiobutton1 = findViewById(R.id.hex);
        radiobutton = findViewById(R.id.bin);
        if (radiobutton.isChecked())
            counter.setText(Integer.toBinaryString(Integer.parseInt(counter.getText().toString())));
        if (radiobutton1.isChecked())
            counter.setText(Integer.toHexString(Integer.parseInt(counter.getText().toString())));
    }

}



