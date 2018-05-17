package com.example.gabrielmoura.ace1;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Apresenta extends AppCompatActivity {

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresenta);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new apresenta_1_Fragment(), "bemvindo");
        adapter.addFragment(new apresenta_2_Fragment(), "BemVindoooos");
        adapter.addFragment(new apresenta_3_Fragment(), "Bemvindos3");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {

        mViewPager.setCurrentItem(fragmentNumber);
    }
}