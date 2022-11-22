package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExplicacionAct1 extends AppCompatActivity {
    Button goazen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicacion_act1);
        goazen = findViewById(R.id.botonGoazen);


        goazen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExplicacionAct1.this, Actividad1.class);
                startActivity(intent);
            }
        });
    }
}