package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//import com.google.firebase.FirebaseApp;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class Buy1NovoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novobuy1);


    }



    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, sneaker_detail.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}
