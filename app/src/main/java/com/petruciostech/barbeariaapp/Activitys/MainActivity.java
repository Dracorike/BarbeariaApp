package com.petruciostech.barbeariaapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.petruciostech.barbeariaapp.R;
import com.petruciostech.barbeariaapp.back4app.Dados;
import com.petruciostech.barbeariaapp.back4app.ParseBarbearia;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ParseBarbearia barbearia;
    private ListView listaDeCortes;
    private List cortes;
    private List lista;
    private Dados corte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barbearia = new ParseBarbearia();
        listaDeCortes = findViewById(R.id.lstListaDeCortes);
        try {
            lista = barbearia.leia();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Context con = this;
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1, lista);
        listaDeCortes.setAdapter(arrayAdapter);
        listaDeCortes.setOnItemClickListener((parent, view, position, id) -> {
            ParseQuery<ParseObject> query = new ParseQuery("Cortes");
            try {
                corte = new Dados();
                corte.setNomeDoCorte(query.find().get(position).getString("NomedoCorte"));
                corte.setPreco(query.find().get(position).getDouble("Price"));
                payCut();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });


    }

    public void payCut(){
        Intent it = new Intent(this, PayHairCut.class);
        it.putExtra("CorteEscolhido", corte);
        startActivity(it);
    }

}