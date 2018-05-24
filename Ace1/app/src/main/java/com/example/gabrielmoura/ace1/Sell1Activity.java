package com.example.gabrielmoura.ace1;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class Sell1Activity extends AppCompatActivity {

    private void openSell2RulesActivity() {
        Intent intent = new Intent(this, Sell2RulesActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell1);

        ImageButton next = (ImageButton) findViewById(R.id.nextbuttonsell1);
        ImageButton back = (ImageButton) findViewById(R.id.backbuttonsell1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell2RulesActivity();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback();
            }
        });
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, sneaker_detail.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    private void Goback() {
        Intent intent = new Intent(this, sneaker_detail.class);
        startActivity(intent);
        finish();
    }
}