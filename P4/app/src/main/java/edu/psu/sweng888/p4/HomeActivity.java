package edu.psu.sweng888.p4;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //set the default page to the list of courses
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content, new MakeupFragment())
                    .commit();
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Set up the hamburger icon for the Navigation Drawer
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); //ensure that actionbar is allowed in the themes
        }
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        // Inflate the menu in the NavigationView
        navigationView.inflateMenu(R.menu.nav_menu);

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                // Handle Home fragment
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, new MakeupFragment())
                        .commit();
            } else if (itemId == R.id.nav_account) {

                AccountFragment fragment = new AccountFragment();
                // Create a bundle to pass data to the fragment
                Bundle args = new Bundle();
                args.putString("key_name", getIntent().getStringExtra("name"));
                args.putString("key_email", getIntent().getStringExtra("email"));
                args.putString("password", getIntent().getStringExtra("password"));
                // Set the arguments to the fragment
                fragment.setArguments(args);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, fragment)
                        .commit();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

