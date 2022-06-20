package com.example.carrinhodecompras;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner sp_qtd;
    private Button bt_adicionar,bt_finalizar;
    private ItemsPreferencia preferencia;
    private String nomeP="",valorP="";
    private RecyclerView recyclerView;
    private List<Carrinho> carrinhoo = new ArrayList<>();
    Adapter adapter = new Adapter(carrinhoo);

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_adicionar = findViewById(R.id.bt_adicionarItem);
        bt_finalizar = findViewById(R.id.bt_finalizar);
        sp_qtd = findViewById(R.id.spinner_qtd);
        preferencia = new ItemsPreferencia(getApplicationContext());

        nomeP = preferencia.recuperarItens("nome");
        valorP = preferencia.recuperarItens("valor");
        if(nomeP!=""&&valorP!=""){
            criarItem();
        }


        bt_adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent adicionarI = new Intent(MainActivity.this,AdicionarItem.class);
                startActivity(adicionarI);

            }
        });
        bt_finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Toast.makeText(getApplicationContext(), carrinho.get(position).getNome(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                //Toast.makeText(getApplicationContext(), "Clique longo!", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }));



    }
    public void criarItem(){
        carrinhoo.add(new Carrinho(nomeP,valorP));
        adapter.notifyItemInserted(carrinhoo.size());
    }
}