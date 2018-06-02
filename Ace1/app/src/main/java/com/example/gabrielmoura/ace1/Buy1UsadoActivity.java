package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.View;

public class Buy1UsadoActivity extends AppCompatActivity {



    private  void openBuy2UsadoActivity() {
        Intent intentbn2 = new Intent(this, Buy2UsadoActivity.class);
        startActivity(intentbn2);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usadobuy1);

        Button comprartenis1 = (Button) findViewById(R.id.precotenisusado1);
        ImageButton back = (ImageButton) findViewById(R.id.usadobuy1backbutton);

        comprartenis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuy2UsadoActivity();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback();
            }
        });


    }
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, TabPages.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
    private void Goback() {
        Intent intent = new Intent(this, TabPages.class);
        startActivity(intent);
        finish();
    }
}
