package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Sell6ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell6_review);

        ImageButton next = (ImageButton) findViewById(R.id.nextbuttonsell6);
        ImageButton back = (ImageButton) findViewById(R.id.backbuttonsell6);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenTabActivity();
            }
        });

    }
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, Sell4ObservationsActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;

    }

    private void Goback() {
        Intent intent = new Intent(this, Sell4ObservationsActivity.class);
        startActivity(intent);
        finish();
    }

    private void OpenTabActivity() {
        Intent intent = new Intent(this, TabPages.class);
        startActivity(intent);
        finish();
    }

}
