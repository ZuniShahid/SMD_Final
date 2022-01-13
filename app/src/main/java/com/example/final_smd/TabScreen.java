package com.example.final_smd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class TabScreen extends AppCompatActivity {
    TabLayout tableLayout;
    ViewPager2 page2;
    fragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_screen);
        tableLayout = findViewById(R.id.tablayout);
        page2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();

        adapter = new fragmentAdapter(fm, getLifecycle());

        page2.setAdapter(adapter);
        tableLayout.addTab(tableLayout.newTab().setText("Rocket"));
        tableLayout.addTab(tableLayout.newTab().setText("Weather"));
        tableLayout.addTab(tableLayout.newTab().setText("Reserve"));

        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        page2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tableLayout.selectTab(tableLayout.getTabAt(position));
            }
        });
    }

}