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

public class ExplicacionAct2 extends AppCompatActivity {
    Button goazen;
    Switch volumen;
    TextView texto;
    ImageView imagen;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicacion_act2);

        //Enlazar IDs a los elementos del layaout
        goazen = findViewById(R.id.botonGoazen);
        texto = findViewById(R.id.texto);
        imagen = findViewById(R.id.imagenquecambia);
        volumen = findViewById(R.id.volumen);

        // Ponemos
        goazen.setClickable(false);

        mediaPlayer = MediaPlayer.create(this, R.raw.explicacion_act2);
        mediaPlayer.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                imagen.setVisibility(View.VISIBLE);
            }
        }, 15000);
        texto.setText("Bigarren kokalekuan gaude: Arrantzaleen auzoan. Arrantzaleen auzoa Mamarigan dago. Etxe hauek arrantzale eta sardina-saltzaileentzat pentsatuak izan ziren. Etxe ohikoenak bi edo hiru solairu zituzten, behekoa tresna-biltegirako erabiltzen zen; beste biak, berriz, etxebizitzarako. \n");

        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct2.this, R.anim.animaciontexto));

        handler.postDelayed(new Runnable() {
            public void run() {
                texto.setText("Etxe hauetan arrantzaleak eta sardina-saltzaileak bizi ziren. Arrantzaleak itsasora joaten ziren arrantzara, batzuetan orduak bakarrik ematen zituzten itsasoan, baina beste askotan egunak. Sardina-saltzaileak itxaroten geratzen ziren, arrantzaleak noiz bueltatzen ziren ikusteko eta haien bila joateko. Horregatik, etxeak hemen eraiki ziren, hemendik itsasoa primeran ikusten delako.\n");

            }
        }, 10000);
        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct2.this, R.anim.animaciontexto));

        handler.postDelayed(new Runnable() {
            public void run() {
                texto.setText("Orain, Arrantzaleen auzoa ezagutzen duzula, hurrengo jolasari ekingo diozu: argazki bikoteak. Argazkiak ikusteko 3 segundo izango dituzu eta behin denbora hori igarota argazki guztiak biratuko dira. Beraz, hasi bikoteak sortzen!\n");
            }
        }, 12000);
        texto.startAnimation(AnimationUtils.loadAnimation(ExplicacionAct2.this, R.anim.animaciontexto));

        goazen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();

                Intent intent = new Intent(ExplicacionAct2.this, Actividad2.class);
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