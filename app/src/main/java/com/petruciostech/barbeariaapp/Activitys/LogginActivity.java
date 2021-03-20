package com.petruciostech.barbeariaapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.petruciostech.barbeariaapp.R;
import com.petruciostech.barbeariaapp.back4app.ParseBarbearia;

public class LogginActivity extends AppCompatActivity {
    private EditText EMAIL_ADDRESS;
    private EditText PASSWORD;
    private ParseBarbearia DATA_BANK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggin_activity);

        EMAIL_ADDRESS = findViewById(R.id.txtEmailAddress);
        PASSWORD = findViewById(R.id.txtPassWord);
        DATA_BANK = new ParseBarbearia();
    }

    public void cadastrar(View view){
        Intent it = new Intent(this, SigningAcitivity.class);
        startActivity(it);
    }


}