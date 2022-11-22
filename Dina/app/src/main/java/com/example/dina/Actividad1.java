package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad1 extends AppCompatActivity {
    private final String[] respuestas = new String[] {"santurce","salla","deprisa","gritando","compra","sardinitas","ricas","yo"};
    Button egiaztatu;
    EditText gap1,gap2,gap3,gap4,gap5,gap6,gap7,gap8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

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


        egiaztatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(comprobarResultados()){
                    // la ha hecho bien, le damos una pieza
                    Dialogo_gana_pieza_act1 d1 = new Dialogo_gana_pieza_act1();
                    d1.show(getSupportFragmentManager(),"mensaje");
                }
                else{
                    // mal, vuelve a empezar
                    Dialogo_repetir_tarea d2 = new Dialogo_repetir_tarea();
                    d2.show(getSupportFragmentManager(),"mensaje2");
                    vaciar();

                }
            }

        });

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
}