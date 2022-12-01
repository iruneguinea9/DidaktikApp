package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class mapa extends AppCompatActivity {
    Button puzzlefinal;
    TextView contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        //ids

        puzzlefinal = findViewById(R.id.puzzleBtn);
        contador = findViewById(R.id.contadorPuzzle);

        // BBDD
        HechosSQLiteHelper dinadbh =
                new HechosSQLiteHelper(this, "DBDina", null, 1);
        ProgresoDao pd = new ProgresoDao();
        int cuantos = pd.cuantosJuegosHechos(dinadbh);
        contador.setText(cuantos+"");

    }
}