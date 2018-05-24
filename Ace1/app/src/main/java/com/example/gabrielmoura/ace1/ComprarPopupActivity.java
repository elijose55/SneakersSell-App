package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ComprarPopupActivity extends AppCompatActivity {

    private  void openBuy2UsadoActivity() {
        Intent intentbn22 = new Intent(this, Buy2UsadoActivity.class);
        startActivity(intentbn22);
        finish();
    }
    private  void openTabPages() {
        Intent intentcheckout = new Intent(this, TabPages.class);
        startActivity(intentcheckout);
        finish();
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comprarpopup);

        ImageView fecharpopupimg = (ImageView) findViewById(R.id.sairpopup);
        fecharpopupimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuy2UsadoActivity();
            }
        });

        ImageButton voltarinicioimgbtn = (ImageButton) findViewById(R.id.finalizarcompraimgbtn);
        voltarinicioimgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTabPages();
            }
        });


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width= dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width),(int)(height));



    }
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, Buy2UsadoActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }



}


