package com.dicoding.picodiploma.jetpackdicoding.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.dicoding.picodiploma.jetpackdicoding.R;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeViewPagerAdapter homePagerAdapter = new HomeViewPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(homePagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        if (getSupportActionBar() != null){
            getSupportActionBar().setElevation(0);
        }
    }
}
