package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;



public class sneaker_detail extends AppCompatActivity {

    ViewPager viewPager;

    private void openSell1Activity() {
        Intent intent1 = new Intent(this, Sell1Activity.class);
        startActivity(intent1);
        finish();
    }

    private  void openBuy1NovoActivity() {
        Intent intentbn = new Intent(this, Buy1UsadoActivity.class);
        startActivity(intentbn);
        finish();
    }

    private  void openBuy1UsadoActivity() {
        Intent intentbu = new Intent(this, Buy1UsadoActivity.class);
        startActivity(intentbu);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sneaker_detail);

        Button vender = (Button) findViewById(R.id.querovender);

        Button comprarnovobtn = (Button) findViewById(R.id.comprarnovo);

        Button comprarusadobtn = (Button) findViewById(R.id.comprarusado);


        vender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell1Activity();
            }
        });
        comprarnovobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuy1NovoActivity();
            }
        });
        comprarusadobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuy1UsadoActivity();
            }
        });




    }
}