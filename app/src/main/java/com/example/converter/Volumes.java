package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Objects;

public class Volumes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumes);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Spinner sp = findViewById(R.id.spinner_volumes);
        EditText edT = findViewById(R.id.input_text_volumes);
        TextView txtV = findViewById(R.id.results_txtv_volumes);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.volumes, R.layout.support_simple_spinner_dropdown_item);
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
                        result = resA * 236.59;
                        String finalResA = resA +  " US Cups equals " + result + " Milliliters";
                        txtV.setText(finalResA);
                        handled = true;
                        break;

                    case 1:
                        double resB = Integer.parseInt(edT.getText().toString());
                        result = resB * 250;
                        String finalResB = resB +  " Metric Cups equals " + result + " Milliliters";
                        txtV.setText(finalResB);
                        handled = true;
                        break;

                    case 2:
                        double resC = Integer.parseInt(edT.getText().toString());
                        result = resC * 29.57;
                        String finalResC = resC +  " US Ounces equals " + result + " Milliliters";
                        txtV.setText(finalResC);
                        handled = true;
                        break;

                    case 3:
                        double resD = Integer.parseInt(edT.getText().toString());
                        result = resD * 28.41;
                        String finalResD = resD +  " UK Ounces equals " + result + " Milliliters";
                        txtV.setText(finalResD);
                        handled = true;
                        break;

                    case 4:
                        double resE = Integer.parseInt(edT.getText().toString());
                        result = resE * 3785;
                        String finalResE = resE +  " US Gallon equals " + result + " Milliliters";
                        txtV.setText(finalResE);
                        handled = true;
                        break;

                    case 5:
                        double resF = Integer.parseInt(edT.getText().toString());
                        result = resF * 4546;
                        String finalResF = resF +  " UK Gallon equals " + result + " Milliliters";
                        txtV.setText(finalResF);
                        handled = true;
                        break;

                    case 6:
                        double resG = Integer.parseInt(edT.getText().toString());
                        result = resG * 473;
                        String finalResG = resG +  " US Pint equals " + result + " Milliliters";
                        txtV.setText(finalResG);
                        handled = true;
                        break;

                    case 7:
                        double resH = Integer.parseInt(edT.getText().toString());
                        result = resH * 568;
                        String finalResH = resH +  " UK Pint equals " + result + " Milliliters";
                        txtV.setText(finalResH);
                        handled = true;
                        break;

                }

            }

            return handled;
        });


    }
}