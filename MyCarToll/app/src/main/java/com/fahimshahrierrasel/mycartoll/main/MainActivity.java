package com.fahimshahrierrasel.mycartoll.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.fahimshahrierrasel.mycartoll.R;
import com.fahimshahrierrasel.mycartoll.data.model.Driver;
import com.fahimshahrierrasel.mycartoll.home.HomeFragment;
import com.fahimshahrierrasel.mycartoll.home.HomePresenter;
import com.fahimshahrierrasel.mycartoll.log.LogFragment;
import com.fahimshahrierrasel.mycartoll.log.LogPresenter;

import nouri.in.goodprefslib.GoodPrefs;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private HomePresenter homePresenter;
    private LogPresenter logPresenter;

    GoodPrefs goodPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        goodPrefs = GoodPrefs.getInstance();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        showHomeFragment();
    }

    private void showHomeFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentFrame);
        HomeFragment homeFragment;
        if (fragment instanceof HomeFragment) {
            homeFragment = (HomeFragment) fragment;

        } else {
            homeFragment = HomeFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentFrame, homeFragment)
                    .commit();
        }
        homePresenter = new HomePresenter(homeFragment);
    }

    private void showLogFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentFrame);
        LogFragment logFragment;
        if (fragment instanceof LogFragment) {
            logFragment = (LogFragment) fragment;

        } else {
            Driver driver = goodPrefs.getObject("driver", Driver.class);
            logFragment = LogFragment.newInstance(driver.getId(), "DRIVER");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentFrame, logFragment)
                    .addToBackStack(null)
                    .commit();
        }
        logPresenter = new LogPresenter(logFragment);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            showHomeFragment();
        } else if (id == R.id.nav_cars) {

        } else if (id == R.id.nav_logs) {
            showLogFragment();
        } else if (id == R.id.nav_profile) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
