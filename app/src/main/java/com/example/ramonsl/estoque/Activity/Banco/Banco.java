package com.example.ramonsl.estoque.Activity.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper{




    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "produtos";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String QUANTIDADE = "quantidade";
    public static final String PRECO = "preco";
    public static final String PERECIVEL = "perecivel";
    public static final int VERSAO = 1;



    public  Banco(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + QUANTIDADE + " integer,"
                + PRECO + " real,"
                + PERECIVEL + " integer"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "  + TABELA);
        onCreate(db);
    }
}


