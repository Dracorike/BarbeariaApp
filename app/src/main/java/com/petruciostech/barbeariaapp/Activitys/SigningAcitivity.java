package com.petruciostech.barbeariaapp.Activitys;
/*
* Essa é a classe de cadastro, ela controla a "signing_activity.xml"
* Aqui vai estar as funções de cadastro de um usuário
*/
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.petruciostech.barbeariaapp.R;
import com.petruciostech.barbeariaapp.back4app.ParseBarbearia;

public class SigningAcitivity extends AppCompatActivity {
    private EditText USER_NAME;
    private EditText EMAIL_ADDRESS;
    private EditText PASSWORD;
    private EditText PASSWORD_CONFIRM;
    private ParseBarbearia BANK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signing_activity);
        //Aqui é feito a coleta de dados fornecido pelo usuário
        USER_NAME = findViewById(R.id.txtUserNameSig);
        EMAIL_ADDRESS = findViewById(R.id.txtEmailAddress);
        PASSWORD = findViewById(R.id.txtPassWordSig);
        PASSWORD_CONFIRM = findViewById(R.id.txtPassWordConfirm);
        BANK = new ParseBarbearia();
    }

    public void signingUp(View view){
        //Nesta classe é chamada a função de registro da classe "Parse Barbearia"
        if(PASSWORD_CONFIRM.getText().toString().equals(PASSWORD.getText().toString())){
            BANK.createUser(USER_NAME.getText().toString(), PASSWORD.getText().toString(),
                    EMAIL_ADDRESS.getText().toString(), this);
        }else{
            Toast.makeText(this, "As senhas são diferentes.", Toast.LENGTH_SHORT).show();
        }
    }

}