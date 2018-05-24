package com.example.gabrielmoura.ace1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class Sell2RulesActivity extends AppCompatActivity {

    private CheckBox accept;
    private boolean cb;
    private View view;

    private void openSell3Activity() {
        Intent intent = new Intent(this, Sell3Activity.class);
        startActivity(intent);
        finish();
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.AcceptTermsButton:
                if (checked) {
                    cb = true;
                }
                else {
                    cb = false;
                    break;
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell2rules);
        accept = (CheckBox) findViewById(R.id.AcceptTermsButton);

        ImageButton next= (ImageButton) findViewById(R.id.NextButton);
        ImageButton back = (ImageButton) findViewById(R.id.backbuttonsell2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb == true) {
                    openSell3Activity();
                }
                else{
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback();
            }
        });
    }

    private void Goback() {
        Intent intent = new Intent(this, Sell1Activity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, Sell1Activity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

}

