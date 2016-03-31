package com.example.sunghuncom.hw_1_b_0327;
/**  mobile programming homework #1_B
 //  package name : hw_1_b_0327
 //  this program will show tip and total amount
 //  When the user pushes the ‘Calculate’ button, App should provide the tip and total amount.
 //  Created by Kwak sunghun on 2016. 3. 27.
 //  Copyright © 2016년 Kwak sunghun. All rights reserved.
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText amount;
    RadioButton ten;
    RadioButton fifteen;
    RadioButton twenty;
    Button calcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcul = (Button)findViewById(R.id.button);
        calcul.setOnClickListener(this);
    }

    public void onClick(View v) {
        double totalAmount=0.0;
        double tip = 0.0;
        amount = (EditText) findViewById(R.id.editText);
        totalAmount = Double.valueOf(amount.getText().toString());

        ten = (RadioButton) findViewById(R.id.radioButton);
        fifteen = (RadioButton) findViewById(R.id.radioButton2);
        twenty = (RadioButton) findViewById(R.id.radioButton3);

        //exception handle
        //if user doesn't enter any radio button
        if(  (!ten.isChecked()) && (!fifteen.isChecked()) && (!twenty.isChecked()) ){
            Toast.makeText(getApplicationContext(), "check radio button", Toast.LENGTH_SHORT).show();
            amount.setText("Error : plz check 1 option");
        }

        //exception handel
        //if uesr enter amount that lower than 0
        if(  totalAmount<=0 ){
            Toast.makeText(getApplicationContext(), "Total amount must be bigger than 0", Toast.LENGTH_SHORT).show();
            amount.setText("Error : Amount must be more than 0");
        }

        //cacluate total amount and tip and show the result
        else{
            if (v.getId() == calcul.getId()) {
                if (ten.isChecked()) {
                    tip = (float) totalAmount * 0.1;
                    totalAmount = totalAmount + tip;
                } else if (fifteen.isChecked()) {
                    tip = (float) totalAmount * 0.15;
                    totalAmount = totalAmount + tip;
                } else if (twenty.isChecked()) {
                    tip = (float) totalAmount * 0.2;
                    totalAmount = totalAmount + tip;
                }

                Toast.makeText(getApplicationContext(), "total : " + totalAmount + " \n" + "tip : " + tip + "\n", Toast.LENGTH_SHORT).show();
                amount.setText(totalAmount+"");
            }
        }
    }
}
