package com.example.carrinhodecompras;

import android.content.Context;
import android.content.SharedPreferences;

public class ItemsPreferencia {

    private SharedPreferences preferences;
    private  SharedPreferences.Editor editor;
    private final static String NOME_ARQUIVO = "carrinho";
    //private final static String CHAVE = "itens";
    private Context context;


    public ItemsPreferencia(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
    public void salvarItens(String CHAVE,String carrinho){
        editor.putString(CHAVE, carrinho);
        editor.commit();
    }
    public String recuperarItens(String CHAVE){
        String carrinho = preferences.getString(CHAVE, "");
        return carrinho;
    }



}
