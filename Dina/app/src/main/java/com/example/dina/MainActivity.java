package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button hasi,jarraitu,pruebas;
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

        hasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.crearBBDD();
            }

        });
        jarraitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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