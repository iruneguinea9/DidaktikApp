package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Creditos extends AppCompatActivity {
    TextView desarrolladoresTxt;
    int clickcount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);
        clickcount = 0;
        desarrolladoresTxt = findViewById(R.id.garatzaileak);

        desarrolladoresTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickcount += 1;
                if(clickcount>8){
                    Toast.makeText(Creditos.this, "Clicks para entrar a modo desarrollador: "+(10-clickcount) , Toast.LENGTH_SHORT).show();
                    if (clickcount==10){
                        Intent intent = new Intent(Creditos.this, ParaProbarActividades.class);
                        startActivity(intent);
                    }
                }

            }
        });
    }
}