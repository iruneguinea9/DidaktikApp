package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Actividad5 extends AppCompatActivity {

    private final HashMap<TextView, Boolean> palabras = new HashMap<>();
    private ArrayList <View> arrList = new ArrayList<>();
    private ArrayList <View> arrListAcertadas = new ArrayList<>();
    private GridView gv;
    private TextView resul;
    private Rect rectAntes = new Rect();


    private String[] letrasSopa = new String[]{
            "A","S","J","O","P","K","H","O","H","S","E","H",
            "N","R","N","M","C","J","U","I","J","N","D","P",
            "O","C","R","C","T","V","M","V","K","S","M","C",
            "N","H","A","A","A","I","D","A","R","F","O","K",
            "H","S","U","J","N","Q","N","T","O","V","I","L",
            "B","A","A","G","T","T","Q","K","Z","V","S","M",
            "I","R","N","G","E","X","Z","K","G","A","R","T",
            "M","D","A","L","N","Z","G","A","R","Z","M","C",
            "E","I","P","P","M","E","O","E","L","V","R","B",
            "C","N","L","C","R","L","A","D","P","E","Z","L",
            "M","A","A","Y","P","J","H","F","N","M","F","C",
            "E","I","T","S","A","S","M","U","S","E","O","T"};

    @SuppressLint({"ClickableViewAccessibility", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad5);
        Dialogo_explicacion_act5 d = new Dialogo_explicacion_act5();
        d.show(getSupportFragmentManager(),"mensaje");
        gv = (GridView)findViewById(R.id.gv);
        resul = findViewById(R.id.tvResultadoSopa);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.activity_actividad5_textview, letrasSopa);
        gv.setAdapter(adaptador);

        final String[] anterior = {""};



        cargarMapa();
        gv.setOnTouchListener((view, motionEvent) -> {
            for(int i = 0; i < gv.getChildCount(); i++) {
                View v = gv.getChildAt(i);
                Rect rectAhora = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                if(rectAhora.contains((int)motionEvent.getX(), (int)motionEvent.getY())) {
                    if(!rectAhora.equals(rectAntes)) {
                        rectAntes = rectAhora;
                        arrList.add(v);
                        resul.append(((TextView) v).getText());
                        v.setBackgroundColor(getColor(R.color.amornico));
                        boolean posible = false;
                        for (TextView palabra : palabras.keySet()) {
                            if (!palabras.get(palabra)) {
                                if (palabra.getText().toString().toUpperCase().startsWith(resul.getText().toString())) {
                                    posible = true;
                                }
                                if (palabra.getText().toString().toUpperCase().equals(resul.getText().toString())) {
                                    posible = true;
                                    palabras.put(palabra, true);
                                    palabra.setTextColor(getColor(R.color.azulPrimario));
                                    palabraAcertada();
                                    varificadorCompletado();
                                    resul.setText("");
                                }
                            }
                        }
                        if (!posible) {
                            resul.setText("");
                            limpiarSeleccionado();
                            colorAcertado();
                        }
                    }
                }
            }
            return false;
        });
    }

    private void palabraAcertada(){
        for (View x : arrList){
            arrListAcertadas.add(x);
        }
        arrList.clear();
        colorAcertado();
    }

    private void colorAcertado(){
        for (View x : arrListAcertadas){
            x.setBackgroundColor(getColor(R.color.azulPrimario));
        }
    }

    private void limpiarSeleccionado(){
        for (View x : arrList){
            x.setBackgroundColor(getColor(R.color.blanco));
        }
        arrList.clear();
    }

    private void cargarMapa() {
        palabras.put((TextView)findViewById(R.id.palabraSopa1), false);
        palabras.put((TextView)findViewById(R.id.palabraSopa2), false);
        palabras.put((TextView)findViewById(R.id.palabraSopa3), false);
        palabras.put((TextView)findViewById(R.id.palabraSopa4), false);
        palabras.put((TextView)findViewById(R.id.palabraSopa5), false);
        palabras.put((TextView)findViewById(R.id.palabraSopa6), false);

//        palabras.put((TextView)findViewById(R.id.palabraSopa8), false);
//        palabras.put((TextView)findViewById(R.id.palabraSopa9), false);
    }

    private void varificadorCompletado(){
        if(!palabras.containsValue(false)){
            Dialogo_gana_pieza_act5 d1 = new Dialogo_gana_pieza_act5();
            d1.show(getSupportFragmentManager(),"mensaje");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(Actividad5.this, mapa.class);
                    startActivity(intent);
                    finish();;
                }
            }, 8000);
        }
    }



}