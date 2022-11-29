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
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExplicacionAct4 extends AppCompatActivity {
    Button goazen;
    Switch volumen;
    TextView texto;
    String explicacion;
    ImageView imagen;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicacion_act4);
        goazen = findViewById(R.id.botonGoazen);
        texto = findViewById(R.id.texto);
        imagen = findViewById(R.id.imagenquecambia);
        volumen = findViewById(R.id.volumen);
        goazen.setClickable(false);
        mediaPlayer = MediaPlayer.create(this, R.raw.explicacion_act4);
        mediaPlayer.start();
        explicacion = leer();
        texto.setText(explicacion);
        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct4.this, R.anim.animaciontexto));
        goazen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();

                Intent intent = new Intent(ExplicacionAct4.this, Actividad4.class);
                startActivity(intent);

                finish();
            }
        });
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
    public String leer(){
        String texto ="";
        try {
            InputStream fraw = getResources().openRawResource(R.raw.explicacion4);
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
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        finish();

    }
}