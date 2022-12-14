package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ParaProbarActividades extends AppCompatActivity {

    private Button acti1,acti2,acti3,acti4,acti5, acti6, acti7, puzzle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_probar_actividades);
        Toast.makeText(this, "Modo desarrollador" ,
                Toast.LENGTH_SHORT).show();
        acti1 = findViewById(R.id.botonacti1);
        acti2 = findViewById(R.id.botonacti2);
        acti3 = findViewById(R.id.botonacti3);
        acti4 = findViewById(R.id.botonacti4);
        acti5 = findViewById(R.id.botonacti5);
        acti6 = findViewById(R.id.botonacti6);
        acti7 = findViewById(R.id.botonacti7);
        puzzle = findViewById(R.id.botonacti8);


        acti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParaProbarActividades.this, ExplicacionAct1.class);
                startActivity(intent);
            }

        });
        acti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParaProbarActividades.this, ExplicacionAct2.class);
                startActivity(intent);
            }
        });
        acti3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParaProbarActividades.this, ExplicacionAct3.class);
                startActivity(intent);
            }
        });
        acti4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(ParaProbarActividades.this, Actividad4.class);
                //startActivity(intent);
                Intent intent = new Intent(ParaProbarActividades.this, ExplicacionAct4.class);
                startActivity(intent);
            }
        });
        acti5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParaProbarActividades.this, ExplicacionAct5.class);
                startActivity(intent);
            }
        });
        acti6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParaProbarActividades.this, ExplicacionAct6.class);
                startActivity(intent);
            }
        });
        acti7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParaProbarActividades.this, ExplicacionAct7.class);
                startActivity(intent);
            }
        });
        puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParaProbarActividades.this, Puzzle.class);
                startActivity(intent);
            }
        });
    }
}