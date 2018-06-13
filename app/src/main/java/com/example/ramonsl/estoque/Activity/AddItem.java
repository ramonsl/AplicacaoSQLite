package com.example.ramonsl.estoque.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ramonsl.estoque.R;

public class AddItem extends AppCompatActivity {

    TextView mName;
    TextView mPreco;
    TextView mQuantidade;
    Switch mPerecivel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setNavigationIcon(R.drawable.ic_action_back);
        setSupportActionBar(myToolbar);
        mName = findViewById(R.id.txtNameProduct);
        mPreco = findViewById(R.id.txtPreco);
        mQuantidade = findViewById(R.id.txtQuantidade);
        mPerecivel= findViewById(R.id.switchPerecivel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save,menu);
        return true;
    }


    //manipualando as açoes da Toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:{
                Toast.makeText(getApplicationContext(),"Salvando" + mName.getText(),Toast.LENGTH_LONG).show();
                onBackPressed();
                return true;
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
