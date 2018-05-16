package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Sell2RulesActivity extends AppCompatActivity {

    private CheckBox accept;

    private void openSell3Activity() {
        Intent intent = new Intent(this, Sell3Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell2rules);
       // onCheckboxClicked();
    //}
    //public void onCheckboxClicked() {
        accept = (CheckBox) findViewById(R.id.AcceptTermsButton);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(Sell2RulesActivity.this,
                            "Bro, try Android :)", Toast.LENGTH_LONG).show();
                    //openSell3Activity();
                }
            }
        });
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, Sell1Activity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}

