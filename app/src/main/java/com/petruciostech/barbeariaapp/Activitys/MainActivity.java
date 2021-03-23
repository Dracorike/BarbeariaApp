package com.petruciostech.barbeariaapp.Activitys;
/*
* Essa é uma classe de controle do xml "activity_main.xml",
* ele dita tudo o que acontecer na tela principal do app.
*/
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.petruciostech.barbeariaapp.R;
import com.petruciostech.barbeariaapp.back4app.Dados;
import com.petruciostech.barbeariaapp.back4app.ParseBarbearia;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ParseBarbearia BARBEARIA;
    private ListView LISTA_DE_CORTES;
    private List LISTA_CONTAINER;
    private Dados CORTE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Declaração de variáveis globais
        BARBEARIA = new ParseBarbearia();
        LISTA_DE_CORTES = findViewById(R.id.lstListaDeCortes);
        try {//Try criado por exigencia da função "leia"
            /*
            * Aqui é feito a leitura do nome dos cortes,
            * os nomes são listados numa classe List e mais tarde
            * é adicionado a uma ListView atravez de um "ArrayAdapter"
            */
            LISTA_CONTAINER = BARBEARIA.leia();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /*
        * O adaptador torna possível que o ListView leia o List que foi criado com os nomes dos
        * cortes.
        */
        ArrayAdapter arrayAdapter= new ArrayAdapter(this,
                android.R.layout.simple_expandable_list_item_1, LISTA_CONTAINER);
        LISTA_DE_CORTES.setAdapter(arrayAdapter);

        //O setOnItemClickListener é a função que fará você poder escolher um dos itens da lista
        LISTA_DE_CORTES.setOnItemClickListener((parent, view, position, id) -> {
            ParseQuery<ParseObject> query = new ParseQuery("Cortes");
            try {
                /*
                * O click em um dos itens da lista criará um novo objeto que mais tarde
                * será transferido para o próximo activity.
                */
                CORTE = new Dados();
                CORTE.setNomeDoCorte(query.find().get(position).getString("NomedoCorte"));
                CORTE.setTipoDoCorte(query.find().get(position).getString("Tipo"));
                CORTE.setPreco(query.find().get(position).getDouble("Price"));
                payCut();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        });

    }

    public void payCut(){//Essa função irá abrir a activity "PayHairCut"
        Intent it = new Intent(this, PayHairCut.class);

        //O putExtra fará os dados do corte escolhido ser levado para a próxima activity
        it.putExtra("CorteEscolhido", CORTE);
        startActivity(it);
    }

}