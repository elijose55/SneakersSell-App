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
        Intent intent = new Intent(this, Sell1Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sneaker_detail);

        Button vender = (Button) findViewById(R.id.querovender);

        vender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell1Activity();
            }
        });
    }

    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, TabPages.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}