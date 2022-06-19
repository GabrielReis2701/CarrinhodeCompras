package com.example.carrinhodecompras;

import static com.example.carrinhodecompras.R.array.quantidade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Carrinho> listaCompras;

    public Adapter(List<Carrinho> lista){
        this.listaCompras = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layoutitens, parent, false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Carrinho carrinho = listaCompras.get(position);
        holder.nome.setText(carrinho.getNome());
        holder.valor.setText(carrinho.getValor());
    }

    @Override
    public int getItemCount() {
        return listaCompras.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        //responsável por guardar cada um dos dados antes de serem exibidos
        TextView nome;
        TextView valor;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.tv_nome);
            valor = itemView.findViewById(R.id.tv_valor);
        }
    }
}
