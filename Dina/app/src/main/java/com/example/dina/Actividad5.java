package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.HashMap;

public class Actividad5 extends AppCompatActivity {

    private final HashMap<String, Boolean> palabras = new HashMap<String, Boolean>();
    private GridView gv;
    private TextView resul;


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

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad5);

        gv = (GridView)findViewById(R.id.gv);
        resul = findViewById(R.id.tvResultadoSopa);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.activity_actividad5_textview, letrasSopa);
        gv.setAdapter(adaptador);

        final String[] anterior = {""};
        cargarMapa();
        gv.setOnTouchListener((view, motionEvent) -> {
            for(int i = 0; i < gv.getChildCount(); i++) {
                View v = gv.getChildAt(i);
                System.out.println("*-*--*-*-*-*-*-*-*-*-*-*");
                System.out.println(gv.getChildAt(i));
                System.out.println("*-*--*-*-*-*-*-*-*-*-*-*");
                Rect outRecto = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                Rect aa = new Rect(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
                if(outRecto.contains((int)motionEvent.getX(), (int)motionEvent.getY())) {
                    if(!((TextView) v).getText().equals(anterior[0])) {
                        resul.append(((TextView) v).getText());
                        anterior[0] = (String) ((TextView) v).getText();
                        boolean posible = false;
                        for(String palabra : palabras.keySet()) {
                            if(!palabras.get(palabra)) {
                                if (palabra.toUpperCase().startsWith(resul.getText().toString())) {
                                    posible = true;
                                }
                                if (palabra.toUpperCase().equals(resul.getText().toString())) {
                                    palabras.put(palabra, true);
                                   // comprobarMapa();
                                    resul.setText("");
                                }
                            }
                        }
                        if(!posible) {
                            resul.setText("");
                        }
                    }
                }
            }
            return false;
        });
    }

    private void cargarMapa() {
        palabras.put("asjo", false);
        palabras.put("eitsas", false);
        palabras.put("arrantzale", false);
    }





}