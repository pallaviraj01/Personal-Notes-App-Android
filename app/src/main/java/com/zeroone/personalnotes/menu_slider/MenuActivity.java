package com.zeroone.personalnotes.menu_slider;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;
import com.zeroone.personalnotes.HomeFragment;
import com.zeroone.personalnotes.R;

public class MenuActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_slider);

        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_id, new HomeFragment())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_notes); // Set the default checked item
        }

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_notes) {
                Toast.makeText(MenuActivity.this, "Notes", Toast.LENGTH_SHORT).show();
                replaceFragment(new HomeFragment());
            } else if (id == R.id.nav_reminders) {
                Toast.makeText(MenuActivity.this, "Reminders", Toast.LENGTH_SHORT).show();
                replaceFragment(new RemindersFragment());
            } else if (id == R.id.nav_inspiration) {
                Toast.makeText(MenuActivity.this, "Inspiration", Toast.LENGTH_SHORT).show();
                replaceFragment(new InspirationFragment());
            } else if (id == R.id.nav_personal) {
                Toast.makeText(MenuActivity.this, "Personal", Toast.LENGTH_SHORT).show();
                replaceFragment(new PersonalFragment());
            } else if (id == R.id.nav_work) {
                Toast.makeText(MenuActivity.this, "Work", Toast.LENGTH_SHORT).show();
                replaceFragment(new WorkFragment());
            } else if (id == R.id.nav_archive) {
                Toast.makeText(MenuActivity.this, "Archive", Toast.LENGTH_SHORT).show();
                replaceFragment(new ArchiveFragment());
            } else if (id == R.id.nav_trash) {
                Toast.makeText(MenuActivity.this, "Trash", Toast.LENGTH_SHORT).show();
                replaceFragment(new TrashFragment());
            } else if (id == R.id.nav_settings) {
                Toast.makeText(MenuActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                replaceFragment(new SettingsFragment());
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_id, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (!closeDrawerIfNeeded()) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                getSupportFragmentManager().popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

    private boolean closeDrawerIfNeeded() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}
