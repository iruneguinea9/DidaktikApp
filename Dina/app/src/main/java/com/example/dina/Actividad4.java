package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Actividad4 extends AppCompatActivity {
    EditText respuesta;
    Button comprobar,btn1,btn2,btn3,btn4,btn5,btn6;
    TextView pista;
    String[] respuestasCorrectas = new String[]{"ITSASOA","ARRANTZALEA","PORTUA","KOFRADIA","OLATUA","SANTURTZI"};
    String[] pistas = new String[]{"Ur-masa gazia, gutxi gorabeheralurrazalaren hiru laurden estaltzen duena","Arrantzatzen duen pertsona, batez ere profesionalki horretan aritzen bada","Itsasertzaren gainean edo ibairen baten ertzean kokatutako lekua, ontziek ontziratzeko, lehorreratzeko eta deskargak egiteko erabiltzen dutena","Interes berberak dituzten pertsonen elkartea, kasu honetan arrantza ","Anplitude handiko uhina, uraren azalean sortzen dena haizearen edo korronteen ondorioz ","Sardinengatik eta haien historiagatik ezaguna den euskal herri arrantzalea"};
    String paraComprarar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad4);
        //ids
        respuesta = findViewById(R.id.respuestaTxt);
        comprobar = findViewById(R.id.checkBtn);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        pista = findViewById(R.id.pistaTxt);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[0]);
                paraComprarar = respuestasCorrectas[0];
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[1]);
                paraComprarar = respuestasCorrectas[1];
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[2]);
                paraComprarar = respuestasCorrectas[2];
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[3]);
                paraComprarar = respuestasCorrectas[3];
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[4]);
                paraComprarar = respuestasCorrectas[4];
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[5]);
                paraComprarar = respuestasCorrectas[5];
            }
        });
        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(respuesta.getText().toString().trim().toUpperCase().equals(paraComprarar)){
                    respuesta.setText("");

                }
                else{
                    aviso();
                    respuesta.setText("");
                }
            }
        });
    }
    public void aviso(){
        Toast.makeText(this, "Ez da zuzena!" ,
                Toast.LENGTH_SHORT).show();
    }
}