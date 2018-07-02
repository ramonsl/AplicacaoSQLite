package com.example.ramonsl.estoque.Activity.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {


    public static final String NOME_BANCO = "banco.db";


    public static final int VERSAO = 2;

    public Banco(Context context) {
        super(context, NOME_BANCO,null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ProductContract.ProductEntry.TABELA+"("
                + ProductContract.ProductEntry.ID + " integer primary key autoincrement,"
                + ProductContract.ProductEntry.NOME + " text,"
                + ProductContract.ProductEntry.QUANTIDADE + " integer,"
                + ProductContract.ProductEntry.PRECO + " real,"
                + ProductContract.ProductEntry.FONE + " text,"
                + ProductContract.ProductEntry.FORNECEDOR + " text,"
                + ProductContract.ProductEntry.FOTO + " blob"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "  + ProductContract.ProductEntry.TABELA);
        onCreate(db);
    }




}
