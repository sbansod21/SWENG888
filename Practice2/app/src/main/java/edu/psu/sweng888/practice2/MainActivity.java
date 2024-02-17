package edu.psu.sweng888.practice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.*;


public class MainActivity extends AppCompatActivity {
    public final int REQUEST_CODE = 1; //for when the toast returns
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //course data
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("SWENG 861", "Software Construction", "3","Mohamad Kassab","Students will learn and practice the elements of constructing a large-scale distributed software system using current technologies."));
        courses.add(new Course("SWENG 586", "Requirements Engineering","3", "Mohamad Kassab", "Theory and applications of requirements elicitation, analysis, modeling, validation, testing, and writing for hardware and software systems."));
        courses.add(new Course("SWENG 887", "Software System Architecture", "3","Everton Tavares Guimaraes","Software systems architecture; architectural design principles/patterns; documentation/evaluation of software architectures; reuse of architectural assets through frameworks/software product lines."));
        courses.add(new Course("SWENG 837", "Software System Design", "3", "Joanna DeFranco", "Best practices in the requirements, analysis, and design of large software systems including the Unified Modeling Language and the Unified Process."));
        courses.add(new Course("SWENG 805", "Software Project Management", "3", "Joanna DeFranco", "Analysis and construction of project plans for the development of complex software products; how to manage change and cost control."));
        courses.add(new Course("SWENG 581", "Software Tesing", "3", "Mohamad Kassab", "This course provides a rigorous formal framework and practical information on the testing of software throughout its life cycle."));
        courses.add(new Course("SWENG 585" ,"Pattens","3","Everton Tavares Guimaraes", "This class examines well-known heuristics, principles and patterns in the design and construction of reusable frameworks, packages and components."));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Course List");

        //calling the adapter to make sense of the list above
        CourseAdapter adapter = new CourseAdapter(this, courses);
        ListView listView = (ListView) findViewById(R.id.course_list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //when the back button is clicked this will display the toast
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Returned from Course Details", Toast.LENGTH_SHORT).show();
            }
        }
    }

}