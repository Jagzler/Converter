package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;


public class Weights extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weights);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Spinner sp = findViewById(R.id.spinner_weights);
        EditText edT = findViewById(R.id.input_text_weights);
        TextView txtV = findViewById(R.id.results_txtv_weights);

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weights, R.layout.support_simple_spinner_dropdown_item);
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
                        result = resA * 28.34;
                        String finalResA = resA +  " Ounces equals " + result + " Grams";
                        txtV.setText(finalResA);
                        handled = true;
                        break;

                    case 1:
                        double resB = Integer.parseInt(edT.getText().toString());
                        result = resB * 453.59;
                        String finalResB = resB +  " Pounds equals " + result + " Grams";
                        txtV.setText(finalResB);
                        handled = true;
                        break;

                    case 2:
                        double resC = Integer.parseInt(edT.getText().toString());
                        result = resC * 6.35;
                        String finalResC = resC +  " Stones equals " + result + " Kilograms";
                        txtV.setText(finalResC);
                        handled = true;
                        break;

                }

            }

        return handled;
        });


    }
















}