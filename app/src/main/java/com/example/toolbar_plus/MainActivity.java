package com.example.toolbar_plus;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> llistaTextCard;
    AdapterLlistaItems adapterLlistaItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Omplim les llistes d'items
        llistaTextCard = new ArrayList<>();
        for (int i = 0; i < 43; i++){
            llistaTextCard.add("Text " + i);
        }

        //Li passem les llistes d'items a l'adapter
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterLlistaItems = new AdapterLlistaItems(llistaTextCard);
        recyclerView.setAdapter(adapterLlistaItems);

        //Fem que els items siguin cliquejables
        adapterLlistaItems.setOnClickListener(new View.OnClickListener() {
            //Lo que s'executarà quan es cliqui un item de la llista
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Selecció: " + llistaTextCard.get(recyclerView.getChildAdapterPosition(view)), Toast.LENGTH_LONG).show();
            }
        });

        //Afegim separadors amb ItemDecoration
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        getMenuInflater().inflate(R.menu.menu_toolbar_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_perfil:
                Intent intent = new Intent(this, Perfil.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}