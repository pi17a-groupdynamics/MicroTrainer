package com.meh.microtrainer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//тут всякая дичь для менюхи
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Walk_Main()).commit();
            navigationView.setCheckedItem(R.id.walk);
        }*/

        navigationView.setItemIconTintList(null);//чтоб иконки меню были цветными

    }

    @Override
    public void onBackPressed() { //событие при нажатие кнопки назад
        //т.е. если меню открыто и нажать кнопку назад, меню закроется
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            /*case R.id.walk:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Walk_Main()).commit();
                break;*/
            case R.id.authors:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutUs()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
