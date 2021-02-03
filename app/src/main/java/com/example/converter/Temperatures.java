package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class Temperatures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatures);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Spinner sp = findViewById(R.id.spinner_temperatures);
        EditText edT = findViewById(R.id.input_text_temperatures);
        TextView txtV = findViewById(R.id.results_txtv_temperatures);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperatures, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp.setAdapter(adapter);

        edT.setOnEditorActionListener((textView, i, keyEvent) -> {
            boolean handled = false;
            double result;

            if(i == EditorInfo.IME_ACTION_DONE){
                i = sp.getSelectedItemPosition();
                switch(i)
                {
                    case 0:
                        double resA = Integer.parseInt(edT.getText().toString());
                        result = (resA-32)/1.8;
                        String finalResA = resA +  " Degree Fahrenheit equals " + result + " degree Celsius";
                        txtV.setText(finalResA);
                        handled = true;
                        break;

                    case 1:
                        double resB = Integer.parseInt(edT.getText().toString());
                        result = resB  - 273.15;
                        String finalResB = resB +  " Degree Kelvin equals " + result + " degree Celsius";
                        txtV.setText(finalResB);
                        handled = true;
                        break;

                }

            }

            return handled;
        });


    }
}