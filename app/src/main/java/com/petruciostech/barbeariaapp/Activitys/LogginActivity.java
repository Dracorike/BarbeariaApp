package com.petruciostech.barbeariaapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.petruciostech.barbeariaapp.R;
import com.petruciostech.barbeariaapp.back4app.ParseBarbearia;

public class LogginActivity extends AppCompatActivity {
    private EditText USER_NAME;
    private EditText PASSWORD;
    private ParseBarbearia DATA_BANK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggin_activity);

        USER_NAME = findViewById(R.id.txtUserNameLog);
        PASSWORD = findViewById(R.id.txtPassWordLog);
        DATA_BANK = new ParseBarbearia();
    }

    public void cadastrar(View view){
        Intent it = new Intent(this, SigningAcitivity.class);
        startActivity(it);
    }

    public void logar(View view){
        DATA_BANK.loginUser(USER_NAME.getText().toString(), PASSWORD.getText().toString(),
                this);
        trocarTela();
    }

    public void trocarTela(){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}