package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ComprarPopupActivity extends AppCompatActivity {

    private  void openBuy2Activity() {
        Intent intentbn22 = new Intent(this, Buy2Activity.class);
        startActivity(intentbn22);
        finish();
    }
    private  void openTabPages() {
        Intent intentcheckout = new Intent(this, TabPages.class);
        startActivity(intentcheckout);
        finish();
    }

    //private void Goback(String image, String name, Long price_new) {
    //    Intent intent = new Intent(this, Buy2Activity.class);
    //    intent.putExtra("IMAGE_REFERENCE",image);
    //    intent.putExtra("NAME_REFERENCE",name);
    //    intent.putExtra("PRICE_REFERENCE",price_new);
    //    startActivity(intent);
    //    finish();
    //}


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comprarpopup);

        //final String image = getIntent().getStringExtra("IMAGE_REFERENCE");
        //final String name = getIntent().getStringExtra("NAME_REFERENCE");
        //final Long price_new = getIntent().getLongExtra("PRICE_REFERENCE",0);

        ImageView fecharpopupimg = (ImageView) findViewById(R.id.sairpopup);

        fecharpopupimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuy2Activity();
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
    //public void onBackPressed(){ //Botão BACK padrão do android
    //    startActivity(new Intent(this, Buy2Activity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
    //    finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
    //   return;
    //}


}


