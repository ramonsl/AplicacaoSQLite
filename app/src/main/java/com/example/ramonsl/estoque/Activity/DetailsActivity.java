package com.example.ramonsl.estoque.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramonsl.estoque.Activity.Data.Itens;
import com.example.ramonsl.estoque.R;

public class DetailsActivity extends AppCompatActivity {


    TextView mName;
    TextView mPreco;
    TextView mQuantidade;
    Switch mPerecivel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar myToolbar =  findViewById(R.id.my_toolbar);
        myToolbar.setNavigationIcon(R.drawable.ic_action_back);
        setSupportActionBar(myToolbar);


        Intent intent = getIntent();
        Itens item = (Itens) intent.getSerializableExtra("item"); // pegando o item passando por paramentro
        mName = findViewById(R.id.txtNameProduct);
        mPreco = findViewById(R.id.txtPreco);
        mQuantidade = findViewById(R.id.txtQuantidade);
        mPerecivel= findViewById(R.id.switchPerecivel);

        mName.setText(item.getName());
        mPreco.setText( String.valueOf(item.getPrice()));
        mQuantidade.setText( String.valueOf(item.getQtd()));
        mPerecivel.setChecked(item.isPerishable());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_delete,menu);
        return true;
    }

 /// Usando o menu da toolbar
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:{

                Toast.makeText(getApplicationContext(),"Deletando" + mName.getText(),Toast.LENGTH_LONG).show();
                onBackPressed(); //apos realizar algo volta para active anetrior
                return true;
            }
            case R.id.action_edit:{
                Toast.makeText(getApplicationContext(),"Editando" + mName.getText(),Toast.LENGTH_LONG).show();
                onBackPressed();//apos realizar algo volta para active anetrior

                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }

}
