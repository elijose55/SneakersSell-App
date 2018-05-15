package com.example.gabrielmoura.ace1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class Sell1Activity extends AppCompatActivity {

    private void openSell_RulesActivity() {
        Intent intent = new Intent(this, Sell_RulesActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        Button info1= (Button) findViewById(R.id.InfoButton1);
        Button info2= (Button) findViewById(R.id.InfoButton2);
        Button info3= (Button) findViewById(R.id.InfoButton3);
        Button info4= (Button) findViewById(R.id.InfoButton4);
        Button info5= (Button) findViewById(R.id.InfoButton5);
        Button next= (Button) findViewById(R.id.NextButton);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell_RulesActivity();
            }
        }
    }
    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, MainActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}