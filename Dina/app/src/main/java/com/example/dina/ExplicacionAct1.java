package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExplicacionAct1 extends AppCompatActivity {
    Button goazen;
    TextView texto;
    ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicacion_act1);
        goazen = findViewById(R.id.botonGoazen);
        texto = findViewById(R.id.texto);
        imagen = findViewById(R.id.imagenquecambia);
        imagen.setVisibility(View.INVISIBLE);
        goazen.setClickable(false);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                imagen.setVisibility(View.VISIBLE);
            }
        }, 15000);
        texto.setText("Kaixo lagunak! Dina sardina naiz eta gaur zuekin guztiekin Santurtzi herri arrantzalearen historia ezagutuko dugu. \n");

        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct1.this, R.anim.animaciontexto));

        handler.postDelayed(new Runnable() {
            public void run() {
                texto.setText("\n\n\nBadakizue non gauden? Ikusi dezakezuenez, gure aurrean Santurtziko monumentu ospetsuenetariko bat dugu: La Sardinera. \n\nEskua altxatuta eta gona goratuta dituelarik, eskulturak Santurtziko sardina-saltzaile ospetsuak gogorarazten ditu, eta arrain-salmenta ibiltariaren lan sakrifikatua balioesten du.\n\n Estatua, Rosario Santinik eskainia izan zen, Santurtziko “Bella Charo” sardina-saltzaile ezagunari.\n");

            }
        }, 10000);
        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct1.this, R.anim.animaciontexto));
        handler.postDelayed(new Runnable() {
            public void run() {
                texto.setText("Sardina-saltzaileek sardinaz beteriko 20kg-ko otarrak gainean eramaten zituzten eta eguraldi txarrak ez zuen haien lana eteten, arrain freskoaren salmenta aurrera eraman behar baitzuten. Hauek, jatorriz Mamariga auzokoak ziren eta irrikaz itxaroten zuten haien senar arrantzaleen etorrera. \n\nSardina-saltzaileak plaza honetaraino zetozen portutik etortzen ziren itsasontziak ikustera. Itsasontziak arraunak gora ekartzen bazituen arrainez beteta zetozela esan nahi zuen eta horrela bazen, sardina-saltzaileak korrika jaisten ziren portura.\n");
                imagen.setImageDrawable(getDrawable(R.drawable.gune1_1));

            }
        }, 40000);
        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct1.this, R.anim.animaciontexto));
        handler.postDelayed(new Runnable() {
            public void run() {
                texto.setText("Sardina-saltzaileak herriz herri ibiltzen ziren hain famatua den “Desde Santurce a Bilbao” abestia behin eta berriro abesten. Abesti hau Santurtziko sardina saltzaileen inguruan hitz egiten du. Munduko lanbide enblematikoenetako batean aritzen ziren ehunka emakumeen inguruan hitz egiten du, sardinerak hain zuzen ere. Abestia entzun nahi duzu? \n");
                imagen.setImageDrawable(getDrawable(R.drawable.gune1_1));
                texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct1.this, R.anim.animaciontexto));
                goazen.setClickable(true);
            }
        }, 80000);
        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct1.this, R.anim.animaciontexto));
        goazen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExplicacionAct1.this, Actividad1.class);
                startActivity(intent);
            }
        });
    }
}