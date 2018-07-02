package com.example.ramonsl.estoque.Activity.Banco;

import android.provider.BaseColumns;

public class ProductContract {

    private ProductContract(){};


    public static final class ProductEntry implements BaseColumns{
        public static final String TABELA = "produtos";
        public static final String ID = "_id";
        public static final String NOME = "nome";
        public static final String QUANTIDADE = "quantidade";
        public static final String PRECO = "preco";
        public static final String FORNECEDOR = "fornecedor";
        public static final String FONE = "fone";
        public static final String FOTO = "foto";
    }




}
