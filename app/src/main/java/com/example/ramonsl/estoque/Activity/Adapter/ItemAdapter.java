package com.example.ramonsl.estoque.Activity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ramonsl.estoque.Activity.Data.Item;
import com.example.ramonsl.estoque.R;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(@NonNull Context context, @NonNull List<Item> objects) {
        super(context,  0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView= convertView;

        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.adapter_product_item,parent,false);
        }




        Item current =getItem(position);


        TextView txtNome= listItemView.findViewById(R.id.txtNameProduct);
        TextView txtQuantidade= listItemView.findViewById(R.id.txtQuantidade);
        TextView txtpreco= listItemView.findViewById(R.id.txtPreco);

        txtNome.setText(current.getName());
        txtpreco.setText((String.valueOf(current.getPrice())));
        txtQuantidade.setText((String.valueOf(current.getQtd())));

        return  listItemView;

    }




}
