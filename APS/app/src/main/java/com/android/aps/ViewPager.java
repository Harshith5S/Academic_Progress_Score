package com.android.aps;

import android.os.Bundle;

import Additional.ViewPagerAdapter;
import androidx.fragment.app.FragmentActivity;

public class ViewPager extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_profile);

        androidx.viewpager.widget.ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter (getSupportFragmentManager()));


    }

}
