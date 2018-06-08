package com.example.gabrielmoura.ace1;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;




public class TabPages extends AppCompatActivity {


    private static final String TAG = "TabPages";
    private static final int ACTIVITY_NUM = 0;




    private Context mContext = TabPages.this;

    Bundle bundle = new Bundle();


    private void setupViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DestaquesFragment()); //index 0
        adapter.addFragment(new EmAltaFragment()); //index 1
        adapter.addFragment(new NovidadesFragment()); //index 2

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Destaques");
        tabLayout.getTabAt(1).setText("Em Alta");
        tabLayout.getTabAt(2).setText("Novidades");

        ImageButton btnSell = (ImageButton) findViewById(R.id.btn_sell);
        ImageButton btnProfile = (ImageButton) findViewById(R.id.btn_profile);
        ImageButton btnSearch = (ImageButton) findViewById(R.id.btn_search);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUserinfoActivity();
                // Do something in response to button profile click
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openSearchActivity();
                // Do something in response to button profile click
            }
        });

        btnSell.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button sell click
                openSell1Activity();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Log.d(TAG, "onCreate: starting.");









        setupViewPager();
    }

    private void openUserinfoActivity() {
        Intent intent = new Intent(this, UserinfoActivity.class);
        startActivity(intent);
        finish();
    }
    private void openSell1Activity() {
        Intent intent = new Intent(this, Sell1Activity.class);
        startActivity(intent);
        finish();
    }
    private void openSearchActivity() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        finish();
    }


}


    /**
     * Responsible for adding the 3 tabs: Camera, Home, Messages
     */


