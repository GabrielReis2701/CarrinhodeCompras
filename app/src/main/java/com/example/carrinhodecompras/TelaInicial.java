package com.example.carrinhodecompras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaInicial extends AppCompatActivity {

    private EditText iet_valor;
    private Button bt_inicio;
    private double valor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        iet_valor = findViewById(R.id.iet_valorInicial);
        bt_inicio = findViewById(R.id.bt_inicio) ;

        bt_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    valor = Double.parseDouble(iet_valor.getText().toString());
                }catch (Exception erro){
                    valor =0;
                }
                if(valor<=0){
                    AlertDialog.Builder janela = new AlertDialog.Builder(TelaInicial.this);
                    janela.setTitle("Carrinho de Compras");
                    janela.setMessage("Por favor informe o orçamento inicial antes de continuar!!!");
                    janela.setNeutralButton("OK",null);
                    janela.show();
                }else{
                    AlertDialog.Builder janela = new AlertDialog.Builder(TelaInicial.this);
                    janela.setTitle("Carrinho de Compras");
                    janela.setMessage("O Valor do orçamento inical esta correto?");
                    janela.setNegativeButton("Não",null);
                    janela.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(TelaInicial.this,MainActivity.class);
                            intent.putExtra("valor",valor);
                            startActivity(intent);
                        }
                    });
                    janela.show();
                }


            }
        });
    }
}