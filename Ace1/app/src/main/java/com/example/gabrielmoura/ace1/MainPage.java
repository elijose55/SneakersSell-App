package com.example.gabrielmoura.ace1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    Toolbar mToolbar;
    RecyclerView mRecyclerView;
    List<SneakerData> mSneakerList;
    SneakerData mSneakerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mRecyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(MainPage.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mSneakerList = new ArrayList<>();
        mSneakerData = new SneakerData("Air Max", R.drawable.tenis1);
        mSneakerList.add(mSneakerData);
        mSneakerData = new SneakerData("Beluga", R.drawable.tenis2);
        mSneakerList.add(mSneakerData);
        mSneakerData = new SneakerData("Converse x OW", R.drawable.tenis3);
        mSneakerList.add(mSneakerData);
        mSneakerData = new SneakerData("Air Vapormax x OW ", R.drawable.tenis4);
        mSneakerList.add(mSneakerData);
        mSneakerData = new SneakerData("Jordan", R.drawable.tenis5);
        mSneakerList.add(mSneakerData);

        MyAdapter myAdapter = new MyAdapter(MainPage.this, mSneakerList);
        mRecyclerView.setAdapter(myAdapter);
    }
}