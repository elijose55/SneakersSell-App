package com.example.gabrielmoura.ace1;

import android.app.ProgressDialog;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sell1Activity extends AppCompatActivity {

    private static final String TAG = "s";
    private Button next;
    private EditText nome;
    private EditText email;
    private EditText senha;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    private void openSell2RulesActivity() {
        Intent intent = new Intent(this, Sell2RulesActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell1);

        ImageButton next = (ImageButton) findViewById(R.id.nextbuttonsell1);
        ImageButton back = (ImageButton) findViewById(R.id.backbuttonsell1);

        firebaseAuth = firebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        email = (EditText) findViewById(R.id.emailID);
        senha = (EditText) findViewById(R.id.senhaID);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goback();
            }
        });
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(this, TabPages.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finishAffinity(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    private void Goback() {
        Intent intent = new Intent(this, TabPages.class);
        startActivity(intent);
        finish();
    }

    private void registerUser() {
        String idemail = email.getText().toString().trim();
        String password = senha.getText().toString().trim();

        if(TextUtils.isEmpty(idemail)){
            //email is empty
            Toast.makeText(this, "Please enter  email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)) {
            //senha is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering User...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(idemail,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Sell1Activity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            openSell2RulesActivity();
                        }else{
                            Toast.makeText(Sell1Activity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            Log.e(TAG,"create Account: Fail!", task.getException());
                        }
                    }
                });

    }
}