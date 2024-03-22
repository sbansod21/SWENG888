package edu.psu.sweng888.p4;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.text.method.PasswordTransformationMethod;

import androidx.fragment.app.Fragment;

public class AccountFragment extends Fragment {

    private ToggleButton toggleButtonShowPassword;
    private Button logoutButton;



    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);


        // Update the UI with user details if available
        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString("key_name");
            String email = args.getString("key_email");
            String password = args.getString("password");

            // get the variables from the xml
            TextView nameTextView = view.findViewById(R.id.nameTextView);
            TextView emailTextView = view.findViewById(R.id.emailTextView);
            TextView passwordTextView = view.findViewById(R.id.passwordTextView);
            toggleButtonShowPassword = view.findViewById(R.id.toggleButtonShowPassword);

            //set the values passed in
            nameTextView.setText(name);
            emailTextView.setText(email);
            toggleButtonShowPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked){
                    // Show password in plain text
                    passwordTextView.setText(password);
                }
                if(!isChecked){
                    // Mask password with dots
                    passwordTextView.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            });

        }

        logoutButton = view.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(v -> logoutAndNavigateToLogin());

        return view;
    }
    private void logoutAndNavigateToLogin() {

        // Navigate back to the login page
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish(); // Optional: Close the current activity to prevent going back to it
    }
}

