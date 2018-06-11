package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Buy2Activity extends AppCompatActivity {


    private  void openComprarPopupActivity() {
        Intent intentpop = new Intent(this, ComprarPopupActivity.class);
        startActivity(intentpop);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy2);


        final String image = getIntent().getStringExtra("IMAGE_REFERENCE");
        final String name = getIntent().getStringExtra("NAME_REFERENCE");
        final Long price_new = getIntent().getLongExtra("PRICE_REFERENCE",0);

        ImageView mImage = (ImageView) findViewById(R.id.imageView16);

        TextView mTextName = (TextView) findViewById(R.id.textView28);

        TextView mTextPrice = (TextView) findViewById(R.id.textView29);

        mTextName.setText(name);
        mTextPrice.setText("A partir de R$"+ String.valueOf(price_new));


        //referencia para o storage
        FirebaseStorage storage = FirebaseStorage.getInstance();

        final StorageReference storageRef = storage.getReference("images");

        Glide.with(getApplicationContext())
                .using(new FirebaseImageLoader())
                .load(storageRef.child(image))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .fitCenter()
                .into(mImage);


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
                Goback(image,name,price_new);
            }
        });

    }

    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, Buy1UsadoActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    private void Goback(String image, String name, Long price_new) {
        Intent intent = new Intent(this, Buy1Activity.class);
        intent.putExtra("IMAGE_REFERENCE",image);
        intent.putExtra("NAME_REFERENCE",name);
        intent.putExtra("PRICE_REFERENCE",price_new);
        startActivity(intent);
        finish();
    }
}
