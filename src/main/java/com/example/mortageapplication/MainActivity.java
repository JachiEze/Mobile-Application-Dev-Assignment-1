package com.example.mortageapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    // Declare variables to store UI elements
    private EditText firstamount;
    private EditText rateofinterest;
    private EditText numofmonths;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements by finding their corresponding views in the layout
        output = (TextView) findViewById(R.id.outputString);
        rateofinterest = (EditText) findViewById((R.id.interestText));
        firstamount = (EditText) findViewById((R.id.principalAmt));
        numofmonths = (EditText) findViewById((R.id.monthPeriods));
    }

    // Method to calculate the mortgage amount
    private double calculateMortgage(double interestAmt, double principalAmt, int months){
        double mortgageAmt;

        mortgageAmt = principalAmt *  interestAmt * Math.pow((1 - interestAmt), months) / (Math.pow((1 + interestAmt), months) - 1);

        return mortgageAmt;
    }

    // Method to handling the display of the mortgage
    public void handleCalculateBtn(View v) {
        double mortgageAmt;

        // Retrieve user input from EditText fields and parse them to doubles and an integer
        double interest = Double.parseDouble(rateofinterest.getText().toString());
        double principal = Double.parseDouble(firstamount.getText().toString());
        int months = Integer.parseInt(numofmonths.getText().toString());

        // Calculate the mortgage amount using the calculateMortgage method
        mortgageAmt = calculateMortgage(interest, principal, months);

        // Display the calculated mortgage amount in the TextView
        output.setText("Monthly Payment: $" + mortgageAmt);
    }
}
