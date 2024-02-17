package edu.psu.sweng888.practice2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CourseDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        // Retrieve data from intent
        String courseName = getIntent().getStringExtra("courseName");
        String courseNumber = getIntent().getStringExtra("courseNumber");
        String courseDescription = getIntent().getStringExtra("courseDescription");
        String courseCredits = getIntent().getStringExtra("courseCredits");
        String courseProf = getIntent().getStringExtra("courseProf");

        // Find TextViews and set text
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewNumber = findViewById(R.id.textViewNumber);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        TextView textViewCredit = findViewById(R.id.textViewCredits);
        TextView textViewProf = findViewById(R.id.textViewProf);

        textViewName.setText(courseName);
        textViewDescription.setText(courseDescription);
        textViewNumber.setText(courseNumber);
        textViewCredit.setText(courseCredits);
        textViewProf.setText(courseProf);

        //return to home when the home button is clicked
        Button returnToMainButton = findViewById(R.id.buttonReturnToMain);
        returnToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //returning to MainActivity
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}

