package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Actividad3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

    }

    public void validacion(View view){
        if(comprobacion()){
            // la ha hecho bien, le damos una pieza
            Dialogo_gana_pieza_act3 d1 = new Dialogo_gana_pieza_act3();
            d1.show(getSupportFragmentManager(),"mensaje");
        }
        else {
            // mal, vuelve a empezar
            Dialogo_repetir_tarea d2 = new Dialogo_repetir_tarea();
            d2.show(getSupportFragmentManager(), "mensaje2");
            vaciar();
        }
    }

    public boolean comprobacion(){
        RadioButton rbAcertado;
        rbAcertado = findViewById(R.id.rbFalso1);
        if (!rbAcertado.isChecked()) {
            return false;
        }
        return true;
    }

    private void vaciar(){
        RadioGroup rg;
        rg = findViewById(R.id.radioGroup1);
        rg.clearCheck();
        rg = findViewById(R.id.radioGroup2);
        rg.clearCheck();
        rg = findViewById(R.id.radioGroup3);
        rg.clearCheck();
        rg = findViewById(R.id.radioGroup4);
        rg.clearCheck();
        rg = findViewById(R.id.radioGroup5);
        rg.clearCheck();
    }
}