package edu.psu.sweng888.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.*;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button calculateButton;
    TextView print;
    private EditText bYear;
    private EditText bMonth;
    private EditText fName;
    private EditText lName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaring variables
        print = (TextView) findViewById(R.id.print);
        calculateButton = findViewById(R.id.button);
        bYear = findViewById(R.id.birthYear);
        bMonth = findViewById(R.id.birthMonth);
        fName = findViewById(R.id.FName);
        lName = findViewById(R.id.LName);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get the current date
                final Calendar c = Calendar.getInstance();
                int cYear = c.get(Calendar.YEAR);
                int cMonth = c.get(Calendar.MONTH);

                //get birth date
                String nYear = bYear.getText().toString().trim();
                String nMonth = bMonth.getText().toString().trim();
                String first = fName.getText().toString().trim();
                String last = lName.getText().toString().trim();

                //ensure valid input
                if(nYear.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please Enter a year!",Toast.LENGTH_LONG).show();
                }else if(nMonth.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please Enter a month!",Toast.LENGTH_LONG).show();
                }else if(first.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please Enter your first name!",Toast.LENGTH_LONG).show();
                }else {
                    //VALID INPUT ONLY
                    int year = cYear - (Integer.parseInt(nYear));
                    int month = Integer.parseInt(nMonth);

                    //year calculation
                    if (cMonth <= month) {
                        year--;
                    }

                    //month calculation
                    if (cMonth >= month) {
                        month = cMonth - month;
                    } else {
                        month = 12 + cMonth - month;
                    }

                    //output
                    String txt = "Hey " + first + " " + last + ", You are " + Integer.toString(year) + " years and " + Integer.toString(month) + " months old!";
                    print.setText(txt);
                    Toast.makeText(MainActivity.this, txt, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}