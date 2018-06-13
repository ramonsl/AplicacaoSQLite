package com.example.ramonsl.estoque.Activity.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ramonsl.estoque.Activity.Data.Item;

import java.util.ArrayList;

public class DaoItem {
    private SQLiteDatabase db;
    private Banco banco;

    public DaoItem(Context context){
        banco = new Banco(context);
    }

    public String save(Item item){
        String msg="";

        ContentValues values;
        db = banco.getWritableDatabase();
        values = new ContentValues();
        values.put(Banco.NOME,item.getName());
        values.put(Banco.PRECO,item.getPrice());
        values.put(Banco.QUANTIDADE,item.getQtd());

        if(item.isPerishable()){
            values.put(Banco.PERECIVEL,1);
        }else{
            values.put(Banco.PERECIVEL,0);
        }

        long result=db.insert(Banco.TABELA,null,values);
        if(result==-1){
            msg="Erro";
        }else{
            msg= "Sucesso ";
        }

        return msg;
    }


    public ArrayList<Item> getAll(){

        ArrayList<Item> lista= new ArrayList<>();
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NOME,banco.PRECO,banco.QUANTIDADE,Banco.PERECIVEL};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        while (cursor.moveToNext()){


            int id= cursor.getInt(0);
            String name= cursor.getString(1);
            double preco= cursor.getDouble(3);
            int qtd= cursor.getInt(2);
            int value= cursor.getInt(4);
            boolean isP;
            if(value==0){
                isP=false;
            }else {
                isP=true;
            }

            Item produto = new Item(id,name,qtd,preco,isP);
            lista.add(produto);
        }
        db.close();
        return lista;

    }

    public String remove(Item r){
        String where= Banco.ID+"="+r.getId();
        db = banco.getWritableDatabase();
        db.delete(Banco.TABELA,where,null);
        db.close();
        return r.getName()+ " REMOVIDO";
    }

}
