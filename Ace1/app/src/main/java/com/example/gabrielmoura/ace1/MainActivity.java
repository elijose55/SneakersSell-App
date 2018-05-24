package com.example.gabrielmoura.ace1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarfirebase();

    }

    private void inicializarfirebase() {
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase =  FirebaseDatabase.getInstance();
        databaseReference=  firebaseDatabase.getReference();
    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    //    getMenuInflater().inflate(R.menu.menu_main,menu);
    //    return super.onCreateOptionsMenu(menu);


    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
    //    return true ;
}
