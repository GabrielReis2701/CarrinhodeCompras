package com.example.carrinhodecompras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class AdicionarItem extends AppCompatActivity {

    private EditText iet_nomeP,iet_valorP;
    private Button bt_salvar;
    private ItemsPreferencia preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_item);

        iet_nomeP = findViewById(R.id.iet_nomeProduto);
        iet_valorP = findViewById(R.id.iet_ValorProduto);
        bt_salvar = findViewById(R.id.bt_salvar);
        preferencia = new ItemsPreferencia(getApplicationContext());

        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeP= iet_nomeP.getText().toString();
                String valorP = iet_valorP.getText().toString();
                preferencia.salvarItens("nome",nomeP);
                preferencia.salvarItens("valor",valorP);
                Snackbar.make(view,"Itens Salvos com sucesso!!!",Snackbar.LENGTH_LONG).show();
                Intent voltar = new Intent(AdicionarItem.this,MainActivity.class);
                startActivity(voltar);
            }
        });
    }
}