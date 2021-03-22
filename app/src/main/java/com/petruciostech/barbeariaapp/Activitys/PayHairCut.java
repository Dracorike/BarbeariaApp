package com.petruciostech.barbeariaapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;
import com.petruciostech.barbeariaapp.R;
import com.petruciostech.barbeariaapp.back4app.Dados;

public class PayHairCut extends AppCompatActivity {
    private TextView NOME_DO_CORTE;
    private TextView PRECO_DO_CORTE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_hair_cut);

        NOME_DO_CORTE = findViewById(R.id.lblNomeDoCorte);
        PRECO_DO_CORTE = findViewById(R.id.lblPreco);

        Intent it = getIntent();
        Dados cortePedido = (Dados) it.getSerializableExtra("CorteEscolhido");

        NOME_DO_CORTE.setText(cortePedido.getNomeDoCorte());
        PRECO_DO_CORTE.setText(Double.toString(cortePedido.getPreco()));

    }

    public void comprar(View view){
        ParseObject entity = new ParseObject("Compras");
        entity.put("Comprador", ParseUser.getCurrentUser());
        entity.put("NomeDoCorte", NOME_DO_CORTE.getText().toString());
        entity.put("Preco", Double.parseDouble(PRECO_DO_CORTE.getText().toString()));

        entity.saveInBackground( e ->{
            if(e == null){
                Toast.makeText(PayHairCut.this, "Compra Efetuada", Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(PayHairCut.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }else{
                Toast.makeText(PayHairCut.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}