package com.example.ramonsl.estoque.Activity.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.ramonsl.estoque.Activity.Data.Product;

import java.util.ArrayList;

public class DaoProduct {

    private SQLiteDatabase db;
    private Banco banco;


    public DaoProduct(Context context){
        banco = new Banco(context);
    }


    public String save(Product product){

        ContentValues values;
        long resultado;

        db = banco.getWritableDatabase();
        values = new ContentValues();
        values.put(ProductContract.ProductEntry.NOME,product.getName());
        values.put(ProductContract.ProductEntry.PRECO,product.getName());
        values.put(ProductContract.ProductEntry.QUANTIDADE,product.getQtd());


        resultado = db.insert(ProductContract.ProductEntry.TABELA,null,values);
        if(resultado==-1){
            return "Erro ao inserir registro";
        }else{
            return "Inserido com Sucesso";
        }

    }

    public ArrayList<Product> getAll(){
        ArrayList<Product> lista= new ArrayList<>();
        Cursor cursor;
        String[] campos =  {ProductContract.ProductEntry.ID,ProductContract.ProductEntry.NOME,ProductContract.ProductEntry.PRECO,ProductContract.ProductEntry.QUANTIDADE,ProductContract.ProductEntry.FORNECEDOR,ProductContract.ProductEntry.FONE};
        db = banco.getReadableDatabase();
        cursor = db.query(ProductContract.ProductEntry.TABELA, campos, null, null, null, null, null, null);

        while (cursor.moveToNext()){

            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            double preco = cursor.getDouble(3);
            int qtd = cursor.getInt(2);
            int bol = cursor.getInt(4);
            String fone= cursor.getString(6);
            String fornecedor= cursor.getString(5);


            Product produto = new Product(id,name,qtd,preco,fornecedor,fone);
            lista.add(produto);

        }
        db.close();
        return lista;
    }

    public String remove(Product r){

        String where = ProductContract.ProductEntry.ID + "=" + r.getId();
        db = banco.getReadableDatabase();
        db.delete(ProductContract.ProductEntry.TABELA,where,null);
        db.close();
        return r.getName()+ " Removido";
    }

    public String update(Product oldProduct,Product newProduct){
        ContentValues values;
        String where;
        db = banco.getWritableDatabase();
        where = ProductContract.ProductEntry.ID + "=" + oldProduct.getId();
        values = new ContentValues();
        values.put(ProductContract.ProductEntry.NOME,newProduct.getName());
        values.put(ProductContract.ProductEntry.PRECO,newProduct.getName());
        values.put(ProductContract.ProductEntry.QUANTIDADE,newProduct.getQtd());
        values.put(ProductContract.ProductEntry.FORNECEDOR,newProduct.getFornecedor());
        values.put(ProductContract.ProductEntry.FONE,newProduct.getFone());
        db.update(ProductContract.ProductEntry.TABELA,values,where,null);
        db.close();
        return "Dados atualizados";
    }

    public String update(Product product,int qtd){
        ContentValues values;
        String where;
        db = banco.getWritableDatabase();
        where = ProductContract.ProductEntry.ID + "=" + product.getId();
        values = new ContentValues();
        values.put(ProductContract.ProductEntry.QUANTIDADE,qtd);
        db.update(ProductContract.ProductEntry.TABELA,values,where,null);
        db.close();
        return "Estoque atualizados";
    }
}



