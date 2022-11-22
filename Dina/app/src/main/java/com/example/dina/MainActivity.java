package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button acti1,acti2,acti3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acti1 = findViewById(R.id.botonacti1);
        acti2 = findViewById(R.id.botonacti2);
        acti3 = findViewById(R.id.botonacti3);

        acti1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Actividad1.class);
                startActivity(intent);
            }

        });
        acti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intent);
            }
        });
        acti3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Actividad3.class);
                startActivity(intent);
            }
        });

    }
}