package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Sell3Activity extends AppCompatActivity {

    private void openSell4ObservationActivity() {
        Intent intent4 = new Intent(this, Sell4ObservationsActivity.class);
        startActivity(intent4);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell3);

        ImageButton next = (ImageButton) findViewById(R.id.nextbuttonsell3);
        ImageButton back = (ImageButton) findViewById(R.id.backbuttonsell3);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell4ObservationActivity();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback();
            }
        });
    }

    private void Goback() {
        Intent intent = new Intent(this, Sell2RulesActivity.class);
        startActivity(intent);
        finish();
    }



    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, Sell2RulesActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}
