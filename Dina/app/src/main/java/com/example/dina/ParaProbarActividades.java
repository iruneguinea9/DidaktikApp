package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ParaProbarActividades extends AppCompatActivity {

    private Button acti1,acti2,acti3,acti4,acti5;

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
                Intent intent = new Intent(ParaProbarActividades.this, Actividad3.class);
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
                Intent intent = new Intent(ParaProbarActividades.this, Actividad5.class);
                startActivity(intent);
            }
        });
    }
}