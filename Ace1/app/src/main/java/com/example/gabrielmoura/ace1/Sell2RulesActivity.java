package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sell2RulesActivity extends AppCompatActivity {

    private void openSell3() {
        Intent intent = new Intent(this, Sell3Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell2rules);
        Button accept= (Button) findViewById(R.id.AcceptTermsButton);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell3();
            }
        });
    }
    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, MainActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}

