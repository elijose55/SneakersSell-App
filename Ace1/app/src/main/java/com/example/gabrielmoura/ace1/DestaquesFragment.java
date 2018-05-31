package com.example.gabrielmoura.ace1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.List;



public class DestaquesFragment extends Fragment {
    private static final String TAG = "DestaquesFragment";

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private List<SneakerCardData> mSneakerListDestaques;
    private List<DatabaseReference> mDatabaseReferenceList = new ArrayList<>();
    private SneakerCardData mSneakerCardData;
    private SneakerCardData snk = null;
    private View v;
    private int sneakers_in_page = 11;
    private String link = null;
    private StorageReference tenis_ref;

    public DestaquesFragment() {
        mSneakerListDestaques = new ArrayList<>();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("tag","view");

        v = inflater.inflate(R.layout.fragment_destaques,container,false);



        mToolbar = v.findViewById(R.id.toolbar2);
        mToolbar.setTitle(getResources().getString(R.string.app_name));

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);

        MyAdapter myAdapter = new MyAdapter(getContext(),mSneakerListDestaques);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(v.getContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(myAdapter);



        return v;
    }





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //referencia para o storage
        FirebaseStorage storage = FirebaseStorage.getInstance();
        final StorageReference storageRef = storage.getReference("images");
        StorageReference imagesRef = storageRef.child("images");

        //StorageReference tenis1_ref = storageRef.child("tenis1.jpeg");
        //StorageReference tenis2_ref = storageRef.child("tenis2.jpeg");
        //StorageReference tenis3_ref = storageRef.child("tenis3.jpeg");
        //StorageReference tenis4_ref = storageRef.child("tenis4.jpeg");
        //StorageReference tenis5_ref = storageRef.child("tenis5.jpeg");

        //tenis1_ref.getName();

        DatabaseReference mDatabase;
        //referencia para o database

        ValueEventListener messageListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    snk = dataSnapshot.getValue(SneakerCardData.class);
                    // ...

                    Log.d("tamg",dataSnapshot.getKey()+".jpeg");



                    tenis_ref = storageRef.child(dataSnapshot.getKey() +".jpeg");

                    mSneakerCardData = new SneakerCardData("1", snk.getName(), snk.getPrice(), tenis_ref);
                    mSneakerListDestaques.add(mSneakerCardData);

                    mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);

                    MyAdapter myAdapter = new MyAdapter(getContext(),mSneakerListDestaques);
                    GridLayoutManager mGridLayoutManager = new GridLayoutManager(v.getContext(), 2);
                    mRecyclerView.setLayoutManager(mGridLayoutManager);
                    mRecyclerView.setAdapter(myAdapter);
                    Log.d("tag","event");
                }
                else{Log.d("tag","erro");}

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };


        for (int x = 1; x < sneakers_in_page; x++) {
            link = "tenis" + String.valueOf(x);

            mDatabase = FirebaseDatabase.getInstance().getReference(link);
            mDatabase.addValueEventListener(messageListener);
        }


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