package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v4.view.ViewPager;
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


public class sneaker_detail extends AppCompatActivity {

    ViewPager viewPager;



    private void openSell1Activity() {
        Intent intent1 = new Intent(this, Sell1Activity.class);
        startActivity(intent1);
        finish();
    }

    private  void openBuy1NovoActivity() {
        final String image = getIntent().getStringExtra("IMAGE_REFERENCE");
        final String name = getIntent().getStringExtra("NAME_REFERENCE");
        final Long price_new = getIntent().getLongExtra("PRICE_REFERENCE",0);

        Intent intentbn = new Intent(this, Buy1Activity.class);
        intentbn.putExtra("IMAGE_REFERENCE",image);
        intentbn.putExtra("NAME_REFERENCE",name);
        intentbn.putExtra("PRICE_REFERENCE",price_new);
        startActivity(intentbn);
        finish();
    }

    private  void openBuy1UsadoActivity() {
        final String image = getIntent().getStringExtra("IMAGE_REFERENCE");
        final String name = getIntent().getStringExtra("NAME_REFERENCE");
        final Long price_new = getIntent().getLongExtra("PRICE_REFERENCE",0);

        Intent intentbn = new Intent(this, Buy1Activity.class);
        intentbn.putExtra("IMAGE_REFERENCE",image);
        intentbn.putExtra("NAME_REFERENCE",name);
        intentbn.putExtra("PRICE_REFERENCE",price_new);
        startActivity(intentbn);
        finish();
    }
    private void Goback() {
        Intent intent = new Intent(this, TabPages.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sneaker_detail);

        final String image = getIntent().getStringExtra("IMAGE_REFERENCE");
        final String name = getIntent().getStringExtra("NAME_REFERENCE");
        final Long price_new = getIntent().getLongExtra("PRICE_REFERENCE",0);

        ImageView mImage = (ImageView) findViewById(R.id.imageView3);

        TextView mTextName = (TextView) findViewById(R.id.textView21);

        TextView mTextPriceNew = (TextView) findViewById(R.id.textView23);

        TextView mTextPriceUsed = (TextView) findViewById(R.id.textView22);

        Button vender = (Button) findViewById(R.id.querovender);

        Button comprarnovobtn = (Button) findViewById(R.id.comprarnovo);

        Button comprarusadobtn = (Button) findViewById(R.id.comprarusado);

        ImageButton back = (ImageButton) findViewById(R.id.backbuttonsneakerdetail);





        mTextName.setText(name);
        mTextPriceNew.setText("A partir de R$"+ String.valueOf(price_new));
        mTextPriceUsed.setText("A partir de R$"+ String.valueOf(price_new-300));

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


        vender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell1Activity();
            }
        });
        comprarnovobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuy1NovoActivity();
            }
        });
        comprarusadobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBuy1UsadoActivity();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback();
            }
        });
    }
}