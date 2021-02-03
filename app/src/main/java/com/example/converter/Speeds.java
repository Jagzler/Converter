package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class Speeds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speeds);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Spinner sp = findViewById(R.id.spinner_speeds);
        EditText edT = findViewById(R.id.input_text_speeds);
        TextView txtV = findViewById(R.id.results_txtv_speeds);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.speeds, R.layout.support_simple_spinner_dropdown_item);
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
                        result = resA * 1.61;
                        String finalResA = resA +  " Miles/hour equals " + result + " Kilometers/hour";
                        txtV.setText(finalResA);
                        handled = true;
                        break;

                    case 1:
                        double resB = Integer.parseInt(edT.getText().toString());
                        result = resB * 3.6;
                        String finalResB = resB +  " Meters/second equals " + result + " Kilometers/hour";
                        txtV.setText(finalResB);
                        handled = true;
                        break;

                    case 2:
                        double resC = Integer.parseInt(edT.getText().toString());
                        result = resC * 1.85;
                        String finalResC = resC +  " Knots equals " + result + " Kilometers/hour";
                        txtV.setText(finalResC);
                        handled = true;
                        break;

                }

            }

            return handled;
        });


    }
}