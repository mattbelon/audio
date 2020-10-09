package com.efectivaweb.audio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvLista;

    List<Sonido> listaSonidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(new GridLayoutManager(this, 1));

        listaSonidos = new ArrayList<>();

        listaSonidos.add(new Sonido("Cancion 1", "sonidoUno"));
        listaSonidos.add(new Sonido("Cancion 2", "sonidoDos"));
        listaSonidos.add(new Sonido("Cancion 3", "sonidoTres"));

        RecyclerView.Adapter adaptador = new AdaptadorSonidos(MainActivity.this, listaSonidos);
        rvLista.setAdapter(adaptador);

    }

}