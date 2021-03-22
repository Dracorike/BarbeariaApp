package com.petruciostech.barbeariaapp.back4app;

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

    public void onCreate(){
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("z45IH5uqP1T62tDJiSxe9Is9Ca0atLE3peAj0PZv")
        .clientKey("aO0dzvxWBPxIehCDxHV6pYI3CBCtZoLfYsyeC2YU")
        .server("https://parseapi.back4app.com")
        .build());

    }

    public void createUser(String userName, String passWord, String email, Context context){
        ParseUser user = new ParseUser();
        user.setUsername(userName);
        user.setPassword(passWord);
        user.setEmail(email);

        user.signUpInBackground(e -> {
            if(e == null){
                Toast.makeText(context, "Você foi cadastrado(a) com sucesso!",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List leia() throws ParseException {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Cortes");
        List lista = new ArrayList();

        for(int i = 0; i < query.find().size(); i++){
            lista.add(query.find().get(i).getString("NomedoCorte"));
        }
        return lista;
    }

}
