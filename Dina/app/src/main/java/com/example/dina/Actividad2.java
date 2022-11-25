package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Actividad2 extends AppCompatActivity {

    ImageView ivPuzzle1, ivPuzzle2, ivPuzzle3, ivPuzzle4, ivPuzzle5, ivPuzzle6, ivPuzzle7,
            ivPuzzle8, ivPuzzle9, ivPuzzle10, ivPuzzle11, ivPuzzle12;

    TextView tvNVidas;

    // Varriables del juego
    private int vida = 7;
    private int puntuacion = 0;
    private Carta cartaActiva;

    private String[] listaImagenes = new String[] {"juegodeparejas1", "juegodeparejas2", "juegodeparejas3",
            "juegodeparejas4", "juegodeparejas5", "juegodeparejas6"};


    private List<Carta> listaCartas = new ArrayList<Carta>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        // Declaramos todas las relaciones de las ImageView
        ivPuzzle1 = (ImageView) findViewById(R.id.ivPuzzle1);
        ivPuzzle2 = (ImageView) findViewById(R.id.ivPuzzle2);
        ivPuzzle3 = (ImageView) findViewById(R.id.ivPuzzle3);
        ivPuzzle4 = (ImageView) findViewById(R.id.ivPuzzle4);
        ivPuzzle5 = (ImageView) findViewById(R.id.ivPuzzle5);
        ivPuzzle6 = (ImageView) findViewById(R.id.ivPuzzle6);
        ivPuzzle7 = (ImageView) findViewById(R.id.ivPuzzle7);
        ivPuzzle8 = (ImageView) findViewById(R.id.ivPuzzle8);
        ivPuzzle9 = (ImageView) findViewById(R.id.ivPuzzle9);
        ivPuzzle10 = (ImageView) findViewById(R.id.ivPuzzle10);
        ivPuzzle11 = (ImageView) findViewById(R.id.ivPuzzle11);
        ivPuzzle12 = (ImageView) findViewById(R.id.ivPuzzle12);

        // Declaramos la relacion del TextView
        tvNVidas = (TextView) findViewById(R.id.tvNVidas);

        // Creamos la lista con los IV
        ImageView[] listaIV = new ImageView[] {ivPuzzle1, ivPuzzle2, ivPuzzle3, ivPuzzle4,
                ivPuzzle5, ivPuzzle6, ivPuzzle7, ivPuzzle8, ivPuzzle9, ivPuzzle10, ivPuzzle11,
                ivPuzzle12};

        int contadorPareja = 0;

        for (int i = 0; i < listaIV.length; i++) {
            if (i % 2 == 0) {
                Carta c = new Carta(i, contadorPareja,listaImagenes[contadorPareja], listaIV[i]);
                listaCartas.add(c);
            } else {
                Carta c = new Carta(i, contadorPareja,listaImagenes[contadorPareja], listaIV[i]);
                listaCartas.add(c);
                contadorPareja++;
            }
        }
    }

    private void finDelJuego(boolean ganar){
        if (ganar == true) {
            //Poner codigo de victorioa
        } else {
            //Poner codigo de derrota
        }
    }

    public void voltearCarta(View v) throws InterruptedException {
        if (!(cartaActiva == null)) {
            Carta cartaActual = null;

            // Buscamos la carta selecionada y guardamos su ID
            for (Carta c : listaCartas) {
                if (v.getId() == c.getivPuzzle().getId()) {
                    c.voltear();

                    cartaActual = c;
                }
            }
            cartaActiva.comprobarPareja(cartaActual);

        } else {
            for (Carta c : listaCartas) {
                if (v.getId() == c.getivPuzzle().getId()) {
                    c.voltear();
                    cartaActiva = c;
                }
            }
        }
    }

    private class Carta {
        final String dorso = "piezapuzle20x20escala10";
        private String cara;
        private int id, idPareja;
        private ImageView ivPuzzle;

        private Carta(int id, int idPareja, String cara, ImageView ivPuzzle) {
            this.cara = cara;
            this.id = id;
            this.idPareja = idPareja;
            this.ivPuzzle = ivPuzzle;
        }

        public void voltear() {
            ivPuzzle.setImageResource(getResources().getIdentifier(cara, "drawable", getPackageName()));
        }

        public void ponerDorso() {
            ivPuzzle.setImageResource(getResources().getIdentifier(dorso, "drawable", getPackageName()));
        }

        public void comprobarPareja(Carta c) throws InterruptedException {
            if (c.getIDPareja() == this.idPareja) {
                puntuacion++;
                if (puntuacion == 6) {
                    finDelJuego(true);

                }

                //Ponemos a null la carta activa
                cartaActiva = null;

            } else {
                // Quitamos un punto de vida y comprobamos que no este a cero
                vida--;
                tvNVidas.setText(String.valueOf(vida));
                if (vida == 0) {
                    finDelJuego(false);
                }

                // Volteamos la otra carta y le damos medio segundo para que la vea
                voltear();
                c.voltear();
                Thread.sleep(1000);

                // Volvemos a voltear las cartas
                ponerDorso();
                c.ponerDorso();

                //Ponemos a null la carta activa
                cartaActiva = null;
            }
        }

        public int getID(){
            return this.id;
        }

        public int getIDPareja(){
            return this.idPareja;
        }

        public void setID(int id) {
            this.id = id;
        }

        public void setIDPareja(int idPareja) {
            this.idPareja = idPareja;
        }

        public ImageView getivPuzzle(){
            return ivPuzzle;
        }
    }
}