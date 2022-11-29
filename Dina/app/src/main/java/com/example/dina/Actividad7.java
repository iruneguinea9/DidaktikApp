package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad7 extends AppCompatActivity {

    TextView tvTextoAct7;

    RadioGroup rgActividad7;

    RadioButton rbRespuesta1Act7, rbRespuesta2Act7, rbRespuesta3Act7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad7);

        // Declaramos todas las relaciones de las ImageView
        tvTextoAct7 = (TextView) findViewById(R.id.tvTextoAct7);
        rgActividad7 = (RadioGroup) findViewById(R.id.rgActividad7);
        rbRespuesta1Act7 = (RadioButton) findViewById(R.id.rbRespuesta1Act7);
        rbRespuesta2Act7 = (RadioButton) findViewById(R.id.rbRespuesta2Act7);
        rbRespuesta3Act7 = (RadioButton) findViewById(R.id.rbRespuesta3Act7);

        rgActividad7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Declaramos una variable tipo String para la respuesta
                String respuesta;

                // Cogemos el ID del RadioButton
                int selectedId = rgActividad7.getCheckedRadioButtonId();

                // Creamos el RadioButton con selectedID
                RadioButton rb = (RadioButton) findViewById(selectedId);

                respuesta = (String) rb.getText();

                switch(respuesta) {
                    // Cambiamos la preguntas y respuestas de la encuesta a la segunda pregunta
                    case "12 metro":
                        tvTextoAct7.setText("Non egiten dira lehiaketa horiek?");
                        rbRespuesta1Act7.setText("Euskal Herrian");
                        rbRespuesta2Act7.setText("Kantauriko herri nagusietan");
                        rbRespuesta3Act7.setText("Erantzun guztiak zuzenak dira");

                        // Limpiamos la seleccion
                        limpiarSelecion();

                        break;

                    // Cambiamos la preguntas y respuestas de la encuesta a la tercera pregunta
                    case "Erantzun guztiak zuzenak dira":
                        tvTextoAct7.setText("Gaur egun zertarako erabiltzen dira traineruak?");

                        rbRespuesta1Act7.setText("Arrantzarako");
                        rbRespuesta2Act7.setText("Kirol-lehiaketarako");
                        rbRespuesta3Act7.setText("Erantzun guztiak zuzenak dira");

                        // Limpiamos la seleccion
                        limpiarSelecion();

                        break;

                    case "Kirol-lehiaketarako":
                        // Indormar al usuario de su victoria
                        Dialogo_gana_pieza_act7 d1 = new Dialogo_gana_pieza_act7();
                        d1.show(getSupportFragmentManager(), "mensaje");
                        // TODO cargar la actividad mapa cuando este hecha
                        // TODO agregar un puzle a la puntuacion
                        break;

                    // En el caso de default sera que se han equivocado y tendran que empezar el
                    // cuestionario de nuevo
                    default:
                        // Informar al usuario que ha perdido
                        Dialogo_repetir_tarea d2 = new Dialogo_repetir_tarea();
                        d2.show(getSupportFragmentManager(), "mensaje2");

                        // Dejamos la encuesta como al principio de la actividad
                        tvTextoAct7.setText("Zenbat neurtzen du traineru-estropadetan erabiltzen diren ontziak?");
                        rbRespuesta1Act7.setText("12 metro");
                        rbRespuesta2Act7.setText("15 metro");
                        rbRespuesta3Act7.setText("17 metro");

                        // Limpiamos la seleccion
                        limpiarSelecion();
                }
            }
        });
    }

    // Esta funcion se usa para deselecionar los RB debido al que el metodo clearCheck()
    // de RadioGroup no da errores
    private void limpiarSelecion() {
        rbRespuesta1Act7.setChecked(false);
        rbRespuesta2Act7.setChecked(false);;
        rbRespuesta3Act7.setChecked(false);
    }
}