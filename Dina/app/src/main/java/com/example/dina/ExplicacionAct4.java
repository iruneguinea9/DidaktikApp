package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class ExplicacionAct4 extends AppCompatActivity {
    Button goazen;
    Switch volumen;
    TextView texto;
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
        Handler handler = new Handler();
        texto.setText("Gaur egungo Santurtziko portura iritsi gara behingoz! ");
        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct4.this, R.anim.animaciontexto));

        handler.postDelayed(new Runnable() {
            public void run() {
                texto.setText("\n\n\nOlatu Talkaren eraikuntzak eta portu berriaren sorrerak eragin handia izan zuten Santurtziren eraldaketan. \nKostaldeko eremu batzuk desagertu ondoren, itsasoari irabazitako lursail horretan daude gaur egun Arrantzaleen Kofradia, Arrantza Portua, Parkea, Kiroldegia eta Victoria Erregina Itsas Pasealekua.\n");
            }
        }, 10000);
        handler.postDelayed(new Runnable() {
            public void run() {
                texto.setText("Portuak eta Arrantzaleen Kofradiak egunero egiten diete harrera sasoiko arrain freskoa deskargatzen duten arrantzaleei.");
            }
        }, 40000);
        handler.postDelayed(new Runnable() {
            public void run() {
                texto.setText("Santurtziko portuak, Arrantzaleen Kofradia berritua, El Hogar jatetxe tradizionala, Turismo Bulegoa eta enkante aretoa bere gain hartzen ditu. \nBertan, aldizka, arrain enkante antzeztuak antolatzen dira.");
                texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct4.this, R.anim.animaciontexto));
                goazen.setClickable(true);
            }
        }, 80000);
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
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        finish();

    }
}