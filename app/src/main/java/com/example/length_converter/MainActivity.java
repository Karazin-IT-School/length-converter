package com.example.length_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare layout elements
    Spinner spinnerFrom, spinnerTo;
    EditText amountEdit;
    Button convertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting elements by their Id's
        amountEdit = findViewById(R.id.amountTextField);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        convertButton = findViewById(R.id.convertionButton);

        String[] from = {"Mile", "Km", "Yard", "Foot", "Inch", "Cm"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);

        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        convertButton.setOnClickListener(view -> {
            try {
                Double amount = Double.parseDouble(amountEdit.getText().toString());
                if (spinnerFrom.getSelectedItem().toString() == "Mile") {
                    amount *= 1609;
                }
                else if (spinnerFrom.getSelectedItem().toString() == "Km") {
                    amount *= 1000;
                }
                else if (spinnerFrom.getSelectedItem().toString() == "Yard") {
                    amount *= 0.9144;
                }
                else if (spinnerFrom.getSelectedItem().toString() == "Foot") {
                    amount *= 0.3048;
                }
                else if (spinnerFrom.getSelectedItem().toString() == "Inch") {
                    amount *= 1609;
                }
                else if (spinnerFrom.getSelectedItem().toString() == "Cm") {
                    amount *= 0.01;
                }

                if (spinnerTo.getSelectedItem().toString() == "Mile") {
                    amount /= 1609;
                }
                else if (spinnerTo.getSelectedItem().toString() == "Km") {
                    amount /= 1000;
                }
                else if (spinnerTo.getSelectedItem().toString() == "Yard") {
                    amount /= 0.9144;
                }
                else if (spinnerTo.getSelectedItem().toString() == "Foot") {
                    amount /= 0.3048;
                }
                else if (spinnerTo.getSelectedItem().toString() == "Inch") {
                    amount /= 1609;
                }
                else if (spinnerTo.getSelectedItem().toString() == "Cm") {
                    amount /= 0.01;
                }

                Toast.makeText(getApplicationContext(), "Conversion result: " + amount.toString(), Toast.LENGTH_LONG).show();
            }
            catch (NumberFormatException exception) {
                Toast.makeText(getApplicationContext(), "Enter something! ", Toast.LENGTH_LONG).show();
            }
            catch (NullPointerException exception) {
                Toast.makeText(getApplicationContext(), "Input data should only contain numbers!", Toast.LENGTH_LONG).show();
            }
        });
    }
}