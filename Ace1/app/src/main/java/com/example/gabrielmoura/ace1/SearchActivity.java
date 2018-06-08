package com.example.gabrielmoura.ace1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

    private List<SneakerCardData> mSneakerList;
    private List<DatabaseReference> mDatabaseReferenceList = new ArrayList<>();
    private SneakerCardData mSneakerCardData;
    private SneakerCardData snk = null;
    private int sneakers_in_page = 11;
    private String link = null;
    ArrayList<String> mSneakerNames = new ArrayList<>();

    public SearchActivity() {
        mSneakerList = new ArrayList<>();
    }

    ArrayAdapter adapter;


    private void openDetailActivity(int position){
        Intent intent = new Intent(this, sneaker_detail.class);
        intent.putExtra("IMAGE_REFERENCE",mSneakerList.get(position).getSneakerImage());
        intent.putExtra("NAME_REFERENCE",mSneakerList.get(position).getName());
        intent.putExtra("PRICE_REFERENCE",mSneakerList.get(position).getPrice());
        this.startActivity(intent);


    }
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, TabPages.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final ListView list = (ListView) findViewById(R.id.theList);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);
        Log.d(TAG, "onCreate: Started.");



        //referencia para o storage
        FirebaseStorage storage = FirebaseStorage.getInstance();
        final StorageReference storageRef = storage.getReference("images");

        DatabaseReference mDatabase;
        //referencia para o database

        ValueEventListener messageListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    snk = dataSnapshot.getValue(SneakerCardData.class);

                    Log.d("tamg",dataSnapshot.getKey()+".jpeg");



                    //tenis_ref = storageRef.child(dataSnapshot.getKey() +".jpeg");

                    mSneakerCardData = new SneakerCardData("1", snk.getName(), snk.getPrice(), dataSnapshot.getKey() +".jpeg");
                    mSneakerList.add(mSneakerCardData);
                    mSneakerNames.add(snk.getName());
                    Log.d("tag","event");
                }
                else{Log.d("tag","erro");}

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                // FALHOU
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };


        for (int x = 1; x < sneakers_in_page; x++) {
            link = "tenis" + String.valueOf(x);

            mDatabase = FirebaseDatabase.getInstance().getReference(link);
            mDatabase.addValueEventListener(messageListener);
        }


        adapter = new ArrayAdapter(this, R.layout.list_item_layout, mSneakerNames);
        list.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (SearchActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <? > arg0, View arg1, int position, long id) {

                String name_clicked = (String) list.getItemAtPosition(position);
                int list_position = mSneakerNames.indexOf(name_clicked);
                openDetailActivity(list_position);
            }
        });

    }
}