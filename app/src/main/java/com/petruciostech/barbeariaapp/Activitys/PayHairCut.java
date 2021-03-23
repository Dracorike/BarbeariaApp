package com.petruciostech.barbeariaapp.Activitys;
/*
* Nessa Activity será feita a confirmação da escolha da compra,
* é aqui que você irá ver os detalhes do corte e terá a escolha de comprar.
*/
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.petruciostech.barbeariaapp.R;
import com.petruciostech.barbeariaapp.back4app.Dados;

public class PayHairCut extends AppCompatActivity {
    private TextView NOME_DO_CORTE;
    private TextView PRECO_DO_CORTE;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_hair_cut);

        NOME_DO_CORTE = findViewById(R.id.lblNomeDoCorte);
        PRECO_DO_CORTE = findViewById(R.id.lblPreco);
        imageView = findViewById(R.id.imgIcone);

        //Aqui é onde o app pega as informações da Activity anterior
        Intent it = getIntent();
        Dados cortePedido = (Dados) it.getSerializableExtra("CorteEscolhido");

        //Esses são os objetos que irá mostrar o nome do corte e o preço
        NOME_DO_CORTE.setText(cortePedido.getNomeDoCorte());
        PRECO_DO_CORTE.setText(Double.toString(cortePedido.getPreco()));

        //Nessa estrutura condicional dependendo do corte irá mostrar uma imagem diferente no
        //ImageView
        if(cortePedido.getTipoDoCorte().equals("Cabelo")){
            imageView.setImageResource(R.mipmap.ic_launcher_cabelo_round);
        }else if(cortePedido.getTipoDoCorte().equals("Barba")){
            imageView.setImageResource(R.mipmap.ic_launcher_barba_round);
        }else{
            imageView.setVisibility(View.INVISIBLE);
        }

    }

    public void comprar(View view){//Essa função registra uma compra no banco de dados
        ParseObject entity = new ParseObject("Compras");
        entity.put("Comprador", ParseUser.getCurrentUser());
        entity.put("NomeDoCorte", NOME_DO_CORTE.getText().toString());
        entity.put("Preco", Double.parseDouble(PRECO_DO_CORTE.getText().toString()));

        //A função "saveInBackground" salva a compra no banco de dados do back4app
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