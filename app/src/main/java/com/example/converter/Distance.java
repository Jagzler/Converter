package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class Distance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Spinner sp = findViewById(R.id.spinner_distance);
        EditText edT = findViewById(R.id.input_text_distance);
        TextView txtV = findViewById(R.id.results_txtv_distance);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.distance, R.layout.support_simple_spinner_dropdown_item);
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
                        result = resA * 2.54;
                        String finalResA = resA +  " Inch equals " + result + " Centimeter";
                        txtV.setText(finalResA);
                        handled = true;
                        break;

                    case 1:
                        double resB = Integer.parseInt(edT.getText().toString());
                        result = resB * 30.48;
                        String finalResB = resB +  " Feet equals " + result + " Centimeter";
                        txtV.setText(finalResB);
                        handled = true;
                        break;

                    case 2:
                        double resC = Integer.parseInt(edT.getText().toString());
                        result = resC * 91.44;
                        String finalResC = resC +  " Yard equals " + result + " Centimeter";
                        txtV.setText(finalResC);
                        handled = true;
                        break;

                    case 3:
                        double resD = Integer.parseInt(edT.getText().toString());
                        result = resD * 1.6;
                        String finalResD = resD +  " Miles equals " + result + " Kilometer";
                        txtV.setText(finalResD);
                        handled = true;
                        break;

                }

            }

            return handled;
        });


    }
}