package com.example.gabrielmoura.ace1;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Buy2UsadoActivity extends AppCompatActivity {


    private  void openComprarPopupActivity() {
        Intent intentpop = new Intent(this, ComprarPopupActivity.class);
        startActivity(intentpop);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usadobuy2);

        Button comprarpopup = (Button) findViewById(R.id.checkoutpopup);
        comprarpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openComprarPopupActivity();
            }
        });

        ImageButton back = (ImageButton) findViewById(R.id.usadobuy2backbutton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback();
            }
        });

    }

    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, Buy1UsadoActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    private void Goback() {
        Intent intent = new Intent(this, Buy1UsadoActivity.class);
        startActivity(intent);
        finish();
    }
}
