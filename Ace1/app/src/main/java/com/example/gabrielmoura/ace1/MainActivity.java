package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new apresenta_1_Fragment());
        adapter.addFragment(new apresenta_2_Fragment());
        adapter.addFragment(new apresenta_3_Fragment());

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupViewPager();
    }



}
