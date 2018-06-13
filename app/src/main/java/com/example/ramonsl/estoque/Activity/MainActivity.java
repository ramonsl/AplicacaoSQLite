package com.example.ramonsl.estoque.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramonsl.estoque.Activity.Adapter.ItemAdapter;
import com.example.ramonsl.estoque.Activity.Banco.DaoItem;
import com.example.ramonsl.estoque.Activity.Data.Item;
import com.example.ramonsl.estoque.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    TextView txtQuantidade;
    ItemAdapter adapter;
    SearchView mSearchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
          setSupportActionBar(myToolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

       txtQuantidade=findViewById(R.id.txtInfo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),AddItem.class);
                startActivity(intent);

            }
        });

/*
        final DaoItem daoItem= new DaoItem(getApplicationContext());

        ArrayList<Item> lista = daoItem.getAll();

        ///itens da listView
        lista.add(new Item("Pedra",10,10.0,false));
        lista.add(new Item("Pano",1,20.0,false));
        lista.add(new Item("Feijão",1,20.0,true));
        lista.add(new Item("Feijão",1,20.0,true));
        lista.add(new Item("Feijão",1,20.0,true));


        txtQuantidade.setText("Quantidade de itens:"+lista.size());
        adapter = new ItemAdapter(getApplicationContext(),lista);

        */
        refresh();

        ListView list=  findViewById(R.id.listaItens);
        list.setAdapter(adapter);




///quando clicar sobre um item
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Item item = (Item) parent.getItemAtPosition(position);
              Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
              intent.putExtra("item", item);
                Toast.makeText(getApplicationContext(), "On clic -", Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });


///quando clique longo sobre um item
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = (Item) parent.getItemAtPosition(position);
                DaoItem daoItem1 = new DaoItem(getApplicationContext());
                String msg=daoItem1.remove(item);
                refresh();
                Toast.makeText(getApplicationContext(), msg , Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }


    @Override
    protected void onRestart() {
        final DaoItem daoItem= new DaoItem(getApplicationContext());
        refresh();


        super.onRestart();
    }

    private void refresh(){
        DaoItem daoItem= new DaoItem(getApplicationContext());
        ArrayList<Item> lista = daoItem.getAll();
        txtQuantidade.setText("Quantidade de itens:"+lista.size());
        adapter = new ItemAdapter(getApplicationContext(),lista);
        ListView list=  findViewById(R.id.listaItens);
        list.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action,menu);
        mSearchView = (SearchView) menu.findItem(R.id.search)
                .getActionView();
        mSearchView.setQueryHint("Digite sua busca");
        mSearchView.setBackgroundColor(Color.WHITE);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), "Digitando - " + query, Toast.LENGTH_LONG).show();
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplicationContext(), "Enviado - " + newText, Toast.LENGTH_LONG).show();
                return true;
            }
        });


        return true;
    }



}
