package edu.psu.sweng888.p4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, nameEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        nameEditText = findViewById(R.id.nameEditText);
        Button signUpButton = findViewById(R.id.signUpButton);

        //listener for signup button
        signUpButton.setOnClickListener(v -> signUpUser());
    }

    private void signUpUser() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String name = nameEditText.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign up success, update UI with the signed-up user's information
                        Log.d("SignUpActivity", "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();

                        // Redirect to a splash screen to welcome the user
                         Intent intent = new Intent(SignUpActivity.this, NewAccountActivity.class);
                        intent.putExtra("email", email);
                        intent.putExtra("name", name);
                        intent.putExtra("password", password);
                         startActivity(intent);
                         finish();
                    } else {
                        // If sign up fails, display a message to the user.
                        Log.w("SignUpActivity", "createUserWithEmail:failure", task.getException());
                        if (task.getException() instanceof FirebaseAuthWeakPasswordException) {
                            Toast.makeText(SignUpActivity.this, "Weak password, please use a stronger one.",
                                    Toast.LENGTH_SHORT).show();
                        } else if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            Toast.makeText(SignUpActivity.this, "Invalid email format.",
                                    Toast.LENGTH_SHORT).show();
                        } else if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(SignUpActivity.this, "User with this email already exists.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Sign up failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
