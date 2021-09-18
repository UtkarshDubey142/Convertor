package com.utkarsh.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // global variable
    String inputType;
    String outputType;
    public String userInput;
    // variable for output textView -->
    TextView outputFiled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Targeting the output textView -->
         outputFiled = (TextView) findViewById(R.id.output_TextView);

        // Targeting the output textView -->
        TextView inputFiled = (TextView) findViewById(R.id.userInput_Text);

        // Targeting spinner -->
        Spinner spinner = (Spinner) findViewById(R.id.dropDownSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this , R.array.ConvertType , android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Targeting spinnerTwo -->
        Spinner spinnerTwo = findViewById(R.id.dropDownSpinner_Two);
        spinnerTwo.setAdapter(adapter);

        // Object of IsValid Class -->
        IsValid validIs = new IsValid();

        // Object of Fraction Class -->
        Fraction classF = new Fraction();


        // Taking the value selected from Spinner One (User Input-Type) -->
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputType = adapter.getItem(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Taking the value selected from Spinner Two (User Output-Type) -->
        spinnerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                outputType = adapter.getItem(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // OnClick on Convert Button -->
        Button convertButton = (Button) findViewById(R.id.Convert_Button);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = inputFiled.getText().toString().toUpperCase();

                // getting Checkbox status -->
                boolean checkboxStatus  = ((CheckBox)findViewById(R.id.Fraction_Checkbox)).isChecked();

                if (checkboxStatus)
                {
                    switch (inputType)
                    {
                        case "Hexadecimal":
                            classF.hexaFraction(userInput , outputType);
                            break;
                        case "Decimal":
                            classF.decimalFraction(userInput , outputType);
                            break;
                        case "Octal":
                            classF.octalFraction(userInput , outputType);
                            break;
                        case "Binary":
                            classF.binaryFraction(userInput , outputType);
                            break;
                    }
                    // @Override getResult() gives "Converted-Value"
                    setResult(classF.getResult());
                }
                else
                {
                    switch (inputType)
                    {
                        case "Hexadecimal":
                            validIs.isHexadecimal(userInput , outputType);
                            break;
                        case "Decimal":
                            validIs.isDecimal(userInput , outputType);
                            break;
                        case "Octal":
                            validIs.isOctal(userInput , outputType);
                            break;
                        case "Binary":
                            validIs.isBinary(userInput , outputType);
                            break;
                    }
                    // getResult() gives "Converted-Value"
                    setResult(validIs.getResult());
                }
            }
        });
    }

    // Sets the "Converted-Value" at TextView -->
    public void setResult(String result)
    {
        if(outputFiled != null)
        {
            outputFiled.setText(result);
        }
        else
        {
            Log.d("MainActivity", "showMessage: NULL");
        }
    }
}