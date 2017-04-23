package com.example.sistema.mascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sistema.mascotas.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mFavoritos: // favorito
                Intent intent = new Intent(this, FavoritoMascotas.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Tavo",      R.drawable.ic_perro1, 2));
        mascotas.add(new Mascota("Blacky",    R.drawable.ic_perro2, 4));
        mascotas.add(new Mascota("Mosha",     R.drawable.ic_gato1,  2));
        mascotas.add(new Mascota("Tifon",     R.drawable.ic_perro3, 3));
        mascotas.add(new Mascota("Perla",     R.drawable.ic_gato2,  2));
        mascotas.add(new Mascota("Osita",     R.drawable.ic_gato3,  1));
        mascotas.add(new Mascota("Perla",     R.drawable.ic_gato4,  2));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

}
