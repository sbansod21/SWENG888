package edu.psu.sweng888.p5.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import edu.psu.sweng888.p5.R;

public class SettingsFragment extends Fragment {

    private ToggleButton toggleDarkMode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        // Initialize ToggleButton
        toggleDarkMode = root.findViewById(R.id.toggleDarkMode);

        // Set initial state of ToggleButton based on user preference
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        boolean isDarkModeOn = preferences.getBoolean("darkMode", false);
        toggleDarkMode.setChecked(isDarkModeOn);

        // Set OnCheckedChangeListener for ToggleButton
        toggleDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Update user preference for dark mode
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("darkMode", isChecked);
                editor.apply();

                // Apply dark mode theme
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                // Notify user about dark mode change
                String message = isChecked ? "Dark Mode Enabled" : "Dark Mode Disabled";
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}
