package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sell5CameraActivity extends AppCompatActivity {
    private void openReiewActivity() {
        Intent intent = new Intent(this, Sell6ReviewActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell5camera);

        Button Next = findViewById(R.id.camera);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReiewActivity();
            }
        });

    }
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, Sell4ObservationsActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }


}
