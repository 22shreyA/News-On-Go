 package com.example.news_on_go;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    PagerAdapter pageradapter;
    TabLayout tabLayout;
    TabItem tabhome, tabsports, tabsci, tabtech, tabhealth, tabentertainment;

    String api = "69e3b00176b646b7ab68380f74b450ee";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tabtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(tabtoolbar);

        tabhome = findViewById(R.id.home);
        tabsports = findViewById(R.id.sports);
        tabsci = findViewById(R.id.science);
        tabtech = findViewById(R.id.tech);
        tabhealth = findViewById(R.id.health);
        tabentertainment = findViewById(R.id.entertainment);

        ViewPager viewPager = findViewById(R.id.fragmentcontanier);
        tabLayout = findViewById(R.id.tabs);

        pageradapter = new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pageradapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() >= 0 && tab.getPosition() < 6){
                    pageradapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}