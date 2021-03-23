package com.petruciostech.barbeariaapp.Activitys;
// Nesta classe você faz o loggin a partir do "loggin_acitivity.xml"
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.ParseUser;
import com.petruciostech.barbeariaapp.R;

public class LogginActivity extends AppCompatActivity {
    private EditText USER_NAME;
    private EditText PASSWORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loggin_activity);

        //Aqui é coletado o nome e a senha do usuário
        USER_NAME = findViewById(R.id.txtUserNameLog);
        PASSWORD = findViewById(R.id.txtPassWordLog);
    }

    public void cadastrar(View view){//Essa função chama a janela de cadastro de Usuário
        Intent it = new Intent(this, SigningAcitivity.class);
        startActivity(it);
    }

    public void logar(View view){
        //Nesta função é usado o nome e a senha do usuário para fazer o loggin
        loginUserLocal(USER_NAME.getText().toString(), PASSWORD.getText().toString());
    }

    public void loginUserLocal(String userName, String passWord){
        //Esta é a função que verifica se a senha e o usuário estão certos
        //Caso esteja ele abre a janela principal, caso não aparece uma mensagem de aviso
        //Falando que a senha ou usuário são inválidos
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