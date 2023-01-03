package com.edu.usth.finalappmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class Home_Page_Screen extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_screen);

        mTabLayout = findViewById(R.id.tv_layout);
        mViewpager = findViewById(R.id.view_paper);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewpager.setAdapter(viewPageAdapter);

        mTabLayout.setupWithViewPager(mViewpager);
    }

}