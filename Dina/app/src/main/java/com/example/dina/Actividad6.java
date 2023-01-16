package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Actividad6 extends AppCompatActivity {

    TextView tvAciertos;

    int aciertos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad6);
        Dialogo_explicacion_act6 d = new Dialogo_explicacion_act6();
        d.show(getSupportFragmentManager(),"mensaje");
        tvAciertos = (TextView) findViewById(R.id.tvAciertos);

        tvAciertos.setText(aciertos+"/7 desberdintasun aurkituta");
    }

    public void acierto(View view) {
        ImageView aciertoImg = (ImageView) view;

        aciertoImg.setImageResource(R.drawable.diferencia_encontrada);

        aciertos++;

        tvAciertos.setText(aciertos+"/7 desberdintasun aurkituta");

        if (aciertos == 7) {
            ganar();
        }
    }

    private void ganar() {
        // Indormar al usuario de su victoria
        Dialogo_gana_pieza_act6 d1 = new Dialogo_gana_pieza_act6();
        d1.show(getSupportFragmentManager(),"mensaje");
        // TODO cargar la actividad mapa cuando este hecha

        // Pasamos a True el la actividad en la base de datos
        HechosSQLiteHelper dinadbh =
                new HechosSQLiteHelper(getBaseContext(), "DBDina", null, 1);
        ProgresoDao pd = new ProgresoDao();
        pd.setTrue(dinadbh,"Juego 7");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Actividad6.this, mapa.class);
                startActivity(intent);
                finish();;
            }
        }, 8000);
    }
}