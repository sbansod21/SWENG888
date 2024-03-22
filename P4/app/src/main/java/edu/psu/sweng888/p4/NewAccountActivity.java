package edu.psu.sweng888.p4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewAccountActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY = 5000; // 3 seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        String name =  getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        // Get the email content from the intent
        String emailContent = "Thanks for signing up " + name;

        // Find the TextView in the layout
        TextView emailTextView = findViewById(R.id.loginMail);

        // Set the email content to the TextView
        emailTextView.setText(emailContent);

        //redirect to the home page after a  5 second delay
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(NewAccountActivity.this, HomeActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("name", name);
            intent.putExtra("password", password);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }
}
