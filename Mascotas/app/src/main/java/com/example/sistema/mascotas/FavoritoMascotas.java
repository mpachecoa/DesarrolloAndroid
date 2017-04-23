package com.example.sistema.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.sistema.mascotas.R;

import java.util.ArrayList;

public class FavoritoMascotas extends AppCompatActivity {

    ArrayList<Mascota> favoritoMascotas;
    private RecyclerView rvFavoritoMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito_mascotas);

        Toolbar miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        rvFavoritoMascotas = (RecyclerView) findViewById(R.id.rvFavoritoMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavoritoMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();

    }

    public void inicializarMascotas() {
        favoritoMascotas = new ArrayList<Mascota>();
        favoritoMascotas.add(new Mascota("Blacky",    R.drawable.ic_perro2, 15));
        favoritoMascotas.add(new Mascota("Tifon",     R.drawable.ic_perro3, 10));
        favoritoMascotas.add(new Mascota("Tavo",      R.drawable.ic_perro1, 8));
        favoritoMascotas.add(new Mascota("Blacky",    R.drawable.ic_perro2, 5));
        favoritoMascotas.add(new Mascota("Mosha",     R.drawable.ic_gato1, 4));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(favoritoMascotas, this);
        rvFavoritoMascotas.setAdapter(adaptador);
    }

}
