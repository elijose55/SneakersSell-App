package com.example.gabrielmoura.ace1;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;



public class Buy1Activity extends AppCompatActivity {
    private static final String TAG = "Buy1Activity";

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private List<SneakerCardData> mSneakerList;
    private List<DatabaseReference> mDatabaseReferenceList = new ArrayList<>();
    private SneakerCardData mSneakerCardData;
    private SneakerCardData snk = null;
    private int sneakers_in_page = 5;
    private String link = null;



    public Buy1Activity() {
        mSneakerList = new ArrayList<>();
    }

    private void Goback(String image, String name, Long price_new) {
        Intent intent = new Intent(this, sneaker_detail.class);
        intent.putExtra("IMAGE_REFERENCE",image);
        intent.putExtra("NAME_REFERENCE",name);
        intent.putExtra("PRICE_REFERENCE",price_new);
        startActivity(intent);
        finish();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy1);

        final String image = getIntent().getStringExtra("IMAGE_REFERENCE");
        final String name = getIntent().getStringExtra("NAME_REFERENCE");
        final Long price_new = getIntent().getLongExtra("PRICE_REFERENCE",0);

        mToolbar = findViewById(R.id.toolbar2);

        ImageButton back = (ImageButton) findViewById(R.id.backbutton);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        final Context context = this;

        MyAdapterSell myAdapterSell = new MyAdapterSell(context, mSneakerList);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(context, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(myAdapterSell);


        //referencia para o storage
        FirebaseStorage storage = FirebaseStorage.getInstance();
        final StorageReference storageRef = storage.getReference("images");
        //StorageReference imagesRef = storageRef.child("images");

        //StorageReference tenis1_ref = storageRef.child("tenisc_01.jpg");
        //StorageReference tenis2_ref = storageRef.child("tenis2.jpeg");
        //StorageReference tenis3_ref = storageRef.child("tenis3.jpeg");
        //StorageReference tenis4_ref = storageRef.child("tenis4.jpeg");
        //StorageReference tenis5_ref = storageRef.child("tenis5.jpeg");

        //tenis1_ref.getName();

        DatabaseReference mDatabase;
        //referencia para o database


        for (int x = 1; x < sneakers_in_page; x++) {
            mSneakerCardData = new SneakerCardData("none", name, price_new, image);
            mSneakerList.add(mSneakerCardData);
        }



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback(image,name,price_new);
            }
        });


        //mSneakerCardData = new SneakerCardData("Air Max 1/97 'Sean Wotherspoon'", "nome", 900L, tenis2_ref);
        //mSneakerList.add(mSneakerCardData);
        //mSneakerCardData = new SneakerCardData("Air Max 1/97 'Sean Wotherspoon'", "nome", 900L, tenis3_ref);
        //mSneakerList.add(mSneakerCardData);
        //mSneakerCardData = new SneakerCardData("Air Max 1/97 'Sean Wotherspoon'", "nome", 900L, tenis4_ref);
        //mSneakerList.add(mSneakerCardData);
        //mSneakerCardData = new SneakerCardData("Air Max 1/97 'Sean Wotherspoon'", "nome", 900L, tenis5_ref);
        //mSneakerList.add(mSneakerCardData);


    }


}
