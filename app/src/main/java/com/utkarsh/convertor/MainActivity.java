package com.utkarsh.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // global variable
    String inputType;
    String outputType;
    public String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Targeting the output textView -->
        TextView outputFiled = (TextView) findViewById(R.id.output_TextView);

        // Targeting the output textView -->
        TextView inputFiled = (TextView) findViewById(R.id.userInput_Text);
        //userInput = inputFiled.getText().toString();

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


        // Taking the value selected from Spinner One (User Input-Type) -->
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Object item = parent.getItemAtPosition(position);
                //Log.i("selected" , item.toString());
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
                outputFiled.setText(outputType);
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
                switch (inputType)
                {
                    case "Hexadecimal":
                        showToast("Hexadecimal");
                        validIs.isHexadecimal(userInput , outputType);
                    break;
                    case "Decimal":
                        showToast("Decimal");
                        validIs.isDecimal(userInput , outputType);
                    break;
                    case "Octal":
                        showToast("Octal");
                        validIs.isOctal(userInput , outputType);
                    break;
                    case "Binary":
                        showToast("Binary");
                        validIs.isBinary(userInput , outputType);
                    break;
                    default :
                        showToast(inputType);
                        validIs.isHexadecimal(userInput , outputType);
                    break;
                }
            }
        });

    }

    // Function for Toast message connected with switch -->
    public void showToast (String msg)
    {
        Toast.makeText(this , msg , Toast.LENGTH_SHORT).show();
    }
}