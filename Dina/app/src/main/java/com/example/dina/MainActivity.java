package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button hasi,jarraitu,pruebas;
    private int piezasConseguidas;
    ImageButton creditos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgresoDao pd = new ProgresoDao();
        hasi = findViewById(R.id.hasi);
        jarraitu = findViewById(R.id.jarraitu);
        pruebas = findViewById(R.id.pruebas);
        creditos = findViewById(R.id.creditos);
        HechosSQLiteHelper dinadbh =
                new HechosSQLiteHelper(this, "DBDina", null, 1);
        pd.crearBBDD(dinadbh);
        hasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.juegoNuevo(dinadbh);
                Intent intent = new Intent(MainActivity.this, mapa.class);
                startActivity(intent);
            }

        });
        jarraitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, mapa.class);
                startActivity(intent);
            }
        });
        pruebas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ParaProbarActividades.class);
                startActivity(intent);
            }
        });
        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Creditos.class);
                startActivity(intent);
            }
        });
    }
}