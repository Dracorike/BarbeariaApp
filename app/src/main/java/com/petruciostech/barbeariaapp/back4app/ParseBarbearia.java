package com.petruciostech.barbeariaapp.back4app;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseUser;

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

    public void loginUser(String userName, String passWord, Context context){
        ParseUser.logInInBackground(userName, passWord, (user, e) ->{
            if(user != null){
                Toast.makeText(context, "Você entrou!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
