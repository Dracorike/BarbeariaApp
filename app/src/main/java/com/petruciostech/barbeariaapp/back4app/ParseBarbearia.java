package com.petruciostech.barbeariaapp.back4app;
/*
* Essa classe foi criada para separar as funções "Parse", as quais controlam o bando de dados
* remotamente. Foi separado para ser mais fácil a visualização de como o back4app funciona.
*/
import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import java.util.ArrayList;
import java.util.List;

public class ParseBarbearia extends Application {

    public void onCreate(){//Aqui é feita a ligação do app com o aplicativo
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("z45IH5uqP1T62tDJiSxe9Is9Ca0atLE3peAj0PZv")
        .clientKey("aO0dzvxWBPxIehCDxHV6pYI3CBCtZoLfYsyeC2YU")
        .server("https://parseapi.back4app.com")
        .build());
    }

    public void createUser(String userName, String passWord, String email, Context context){
        //Nessa função é criado o usuário
        ParseUser user = new ParseUser();
        user.setUsername(userName);
        user.setPassword(passWord);
        user.setEmail(email);

        /*
        * Depois que é colocado as informações no ParserUser
        * a função .signUpInBackground faz a criação do novo usuário SE não existir outro
        * igual a esse.
        */
        user.signUpInBackground(e -> {
            if(e == null){
                Toast.makeText(context, "Você foi cadastrado(a) com sucesso!",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*
    * Essa função tem como objetivo por os NOMES dos cortes  numa lista,
    * pra mais tarde ser colocado num ListView no Activity "MainActivity".
    */
    public List leia() throws ParseException {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Cortes");
        List lista = new ArrayList();

        for(int i = 0; i < query.find().size(); i++){
            lista.add(query.find().get(i).getString("NomedoCorte"));
        }
        return lista;
    }

}
