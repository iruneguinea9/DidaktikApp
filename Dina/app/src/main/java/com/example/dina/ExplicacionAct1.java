package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExplicacionAct1 extends AppCompatActivity {
    Button goazen;
    Switch volumen;
    TextView texto;
    ImageView imagen;
    String explicacion;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicacion_act1);
        goazen = findViewById(R.id.botonGoazen);
        texto = findViewById(R.id.texto);
        imagen = findViewById(R.id.imagenquecambia);
        volumen = findViewById(R.id.volumen);
        imagen.setVisibility(View.INVISIBLE);
        goazen.setClickable(false);
        mediaPlayer = MediaPlayer.create(this, R.raw.explicacion_act1);
        mediaPlayer.start();
        explicacion = leer();
        texto.setText(explicacion);
        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct1.this, R.anim.animaciontexto));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                imagen.setVisibility(View.VISIBLE);
            }
        }, 15000);

        handler.postDelayed(new Runnable() {
            public void run() {
                imagen.setImageDrawable(getDrawable(R.drawable.gune1_1));

            }
        }, 40000);
        handler.postDelayed(new Runnable() {
            public void run() {
                imagen.setImageDrawable(getDrawable(R.drawable.gune1_1));
                goazen.setClickable(true);
            }
        }, 80000);

        volumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (volumen.isChecked())
                    mediaPlayer.setVolume(1,1);
                else
                    mediaPlayer.setVolume(0,0);
            }

        });
    }
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        finish();
    }
    public String leer(){
        String texto ="";
        try {
            InputStream fraw = getResources().openRawResource(R.raw.explicacion1);
            BufferedReader brin = new BufferedReader( new InputStreamReader(fraw));
            String linea= brin.readLine();
            texto +=linea;
            while (linea!=null){
                Log.i("Ficheros", linea);
                linea=brin.readLine();
                texto +=linea;
            }
            fraw.close();
        }
        catch (Exception ex) {
            Log.e ("Ficheros", "Error al leer fichero desde recurso raw");
        }

        return texto;
    }
}