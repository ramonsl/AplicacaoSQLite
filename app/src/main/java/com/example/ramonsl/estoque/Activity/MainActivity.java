package com.example.ramonsl.estoque.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramonsl.estoque.Activity.Adapter.productAdapter;
import com.example.ramonsl.estoque.Activity.Banco.DaoProduct;
import com.example.ramonsl.estoque.Activity.Data.Product;
import com.example.ramonsl.estoque.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    productAdapter adapter;
    SearchView mSearchView;
    TextView txtQuantidade;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        txtQuantidade = findViewById(R.id.txtInfo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);

            }
        });

        final DaoProduct dao = new DaoProduct(getApplicationContext());
        //  dao.getAll();
       // ArrayList<Product> lista = dao.getAll();

        //txtQuantidade.setText("Quantidade de itens:" + lista.size());
        //adapter = new productAdapter(getApplicationContext(), lista);
       list= findViewById(R.id.listaItens);
        //list.setAdapter(adapter);

        refreshAdapter();


///quando clicar sobre um item
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product item = (Product) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("item", item);
                Toast.makeText(getApplicationContext(), "On clic -", Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });


///quando clique longo sobre um item
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Product item = (Product) parent.getItemAtPosition(position);
                DaoProduct daoItem = new DaoProduct(getApplicationContext());
                String resposta = daoItem.remove(item);
                Toast.makeText(getApplicationContext(), resposta, Toast.LENGTH_LONG).show();
                refreshAdapter();
                return false;
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action, menu);
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

    @Override
    protected void onRestart() {
        refreshAdapter();
        super.onRestart();
    }

    private void refreshAdapter() {
        DaoProduct dao = new DaoProduct(getApplicationContext());
        ArrayList<Product> lista = dao.getAll();

        if (lista.size() == 0) {
            txtQuantidade.setText("adicione itens ao inventario  clicando no + ");

        } else {
            txtQuantidade.setText("Quantidade de itens:" + lista.size());

        }

        adapter = new productAdapter(getApplicationContext(), lista);
        list = findViewById(R.id.listaItens);
        list.setAdapter(adapter);
    }
}
