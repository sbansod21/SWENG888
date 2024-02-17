package edu.psu.sweng888.practice2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {
    public CourseAdapter(Context context, List<Course> courses) {
        super(context, 0, courses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Course course = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listview, parent, false);
        }

        TextView courseNumber = (TextView) convertView.findViewById(R.id.title);
        TextView courseName = (TextView) convertView.findViewById(R.id.subtitle);
        courseName.setText(course.getName());
        courseNumber.setText(course.getNumber());

        final int REQUEST_CODE = 1;

        Button detailsButton = convertView.findViewById(R.id.button_item);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start the new activity
                Intent intent = new Intent(getContext(), CourseDetailsActivity.class);
                intent.putExtra("courseNumber", course.getNumber());
                intent.putExtra("courseName", course.getName());
                intent.putExtra("courseDescription", course.getDescription());
                intent.putExtra("courseCredits", course.getCredits());
                intent.putExtra("courseProf", course.getProfName());


                ((Activity) getContext()).startActivityForResult(intent, REQUEST_CODE);

            }
        });

        // Return the completed view to render on screen
        return convertView;
    }


}

