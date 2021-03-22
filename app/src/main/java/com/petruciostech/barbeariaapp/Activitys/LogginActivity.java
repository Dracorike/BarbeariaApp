package com.petruciostech.barbeariaapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.petruciostech.barbeariaapp.R;
import com.petruciostech.barbeariaapp.back4app.ParseBarbearia;

public class LogginActivity extends AppCompatActivity {
    private EditText USER_NAME;
    private EditText PASSWORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggin_activity);

        USER_NAME = findViewById(R.id.txtUserNameLog);
        PASSWORD = findViewById(R.id.txtPassWordLog);
    }

    public void cadastrar(View view){
        Intent it = new Intent(this, SigningAcitivity.class);
        startActivity(it);
    }

    public void logar(View view){
        loginUserLocal(USER_NAME.getText().toString(), PASSWORD.getText().toString());
    }

    public void loginUserLocal(String userName, String passWord){
        ParseUser.logInInBackground(userName, passWord,
                (user, e) ->{
                    if(user != null){
                        Intent it = new Intent(LogginActivity.this, MainActivity.class);
                        it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(it);
                    }else{
                        ParseUser.logOut();
                        Toast.makeText(LogginActivity.this, e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}