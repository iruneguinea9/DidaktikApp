package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Actividad1 extends AppCompatActivity {
    private final String[] respuestas = new String[] {"santurce","salla","deprisa","gritando","compra","sardinitas","ricas","yo"};
    private Button egiaztatu;
    private EditText gap1,gap2,gap3,gap4,gap5,gap6,gap7,gap8;
    private ImageButton play,pause,restart;
    private MediaPlayer mediaPlayer;
    private ImageView imagen;
    private TextView explicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        Dialogo_explicacion_act1 d = new Dialogo_explicacion_act1();
        d.show(getSupportFragmentManager(),"mensaje");
        // asignar id
        egiaztatu = findViewById(R.id.egiaztatu);
        gap1 = findViewById(R.id.gap1);
        gap2 = findViewById(R.id.gap2);
        gap3 = findViewById(R.id.gap3);
        gap4 = findViewById(R.id.gap4);
        gap5 = findViewById(R.id.gap5);
        gap6 = findViewById(R.id.gap6);
        gap7 = findViewById(R.id.gap7);
        gap8 = findViewById(R.id.gap8);
        play = findViewById(R.id.botonPlay);
        pause = findViewById(R.id.botonPause);
        restart = findViewById(R.id.botonRestart);
        explicacion = findViewById(R.id.explicacion);
        imagen = findViewById(R.id.imagen);
        explicacion.setText(leer());
        HechosSQLiteHelper dinadbh =
                new HechosSQLiteHelper(this, "DBDina", null, 1);
        mediaPlayer = MediaPlayer.create(this, R.raw.cancion_act1);
        egiaztatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(comprobarResultados()){
                    // la ha hecho bien, le damos una pieza
                    Dialogo_gana_pieza_act1 d1 = new Dialogo_gana_pieza_act1();
                    d1.show(getSupportFragmentManager(),"mensaje");
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            mediaPlayer.stop();
                            // añadir una pieza de puzzle
                            ProgresoDao pd = new ProgresoDao();
                            pd.setTrue(dinadbh,"Juego 1");
                            Intent intent = new Intent(Actividad1.this, mapa.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 8000);
                }
                else{
                    // mal, vuelve a empezar
                    Dialogo_repetir_tarea d2 = new Dialogo_repetir_tarea();
                    d2.show(getSupportFragmentManager(),"mensaje2");
                    vaciar();

                }
            }

        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                mediaPlayer.start();
            }
        });

    }
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        finish();
    }
    private boolean comprobarResultados(){
        if(!gap1.getText().toString().toLowerCase().equals(respuestas[0])) {
            return false;
        }
        if(!gap2.getText().toString().toLowerCase().equals(respuestas[1])) {
            return false;
        }
        if(!gap3.getText().toString().toLowerCase().equals(respuestas[2])) {
            return false;
        }
        if(!gap4.getText().toString().toLowerCase().equals(respuestas[3])) {
            return false;
        }
        if(!gap5.getText().toString().toLowerCase().equals(respuestas[4])) {
            return false;
        }
        if(!gap6.getText().toString().toLowerCase().equals(respuestas[5])) {
            return false;
        }
        if(!gap7.getText().toString().toLowerCase().equals(respuestas[6])) {
            return false;
        }
        if(!gap8.getText().toString().toLowerCase().equals(respuestas[7])) {
            return false;
        }
        return true;
    }
    private void vaciar(){
        gap1.setText("");
        gap2.setText("");
        gap3.setText("");
        gap4.setText("");
        gap5.setText("");
        gap6.setText("");
        gap7.setText("");
        gap8.setText("");
    }
    public String leer(){
        String texto ="";
        try {
            InputStream fraw = getResources().openRawResource(R.raw.juego1);
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