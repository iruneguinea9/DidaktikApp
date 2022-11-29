package com.example.dina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad4 extends AppCompatActivity {
    EditText respuesta;
    Button comprobar,btn1,btn2,btn3,btn4,btn5,btn6;
    TextView pista;
    String[] respuestasCorrectas = new String[]{"ITSASOA","ARRANTZALEA","PORTUA","KOFRADIA","OLATUA","SANTURTZI"};
    String[] pistas = new String[]{"Ur-masa gazia, gutxi gorabeheralurrazalaren hiru laurden estaltzen duena","Arrantzatzen duen pertsona, batez ere profesionalki horretan aritzen bada","Itsasertzaren gainean edo ibairen baten ertzean kokatutako lekua, ontziek ontziratzeko, lehorreratzeko eta deskargak egiteko erabiltzen dutena","Interes berberak dituzten pertsonen elkartea, kasu honetan arrantza ","Anplitude handiko uhina, uraren azalean sortzen dena haizearen edo korronteen ondorioz ","Sardinengatik eta haien historiagatik ezaguna den euskal herri arrantzalea"};
    String paraComprarar;
    TextView i1,t1,s1,a1,s12,o1,a12; //itsasoa
    TextView r2,r22,a2,n2,t2,z2,a22,l2,e2,a23; // arrantzalea
    TextView p3,o3,r3,t3,u3,a3; // portua
    TextView k4,o4,f4,r4,a4,d4,i4,a42; //kofradia
    TextView o5,l5,a5,t5,u5,a52; // olatua
    TextView s6,n6,u6,t6,i6; //santurtzi
    int cualBoton;
    int cont = 0;
    HechosSQLiteHelper dinadbh =
            new HechosSQLiteHelper(this, "DBDina", null, 1);


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
        // itsasoa
        i1 = findViewById(R.id.c01);
        t1 = findViewById(R.id.c02);
        s1 = findViewById(R.id.c03);
        a1 = findViewById(R.id.c04);
        s12 = findViewById(R.id.c05);
        o1 = findViewById(R.id.c06);
        a12 = findViewById(R.id.c07);

        //arrantzalea
        r2 = findViewById(R.id.c17);
        r22 = findViewById(R.id.c27);
        a2 = findViewById(R.id.c37);
        n2 = findViewById(R.id.c47);
        t2 = findViewById(R.id.c57);
        z2 = findViewById(R.id.c67);
        a22 = findViewById(R.id.c77);
        l2 = findViewById(R.id.c87);
        e2 = findViewById(R.id.c97);
        a23 = findViewById(R.id.c107);

        // portua
        p3 = findViewById(R.id.c33);
        o3= findViewById(R.id.c43);
        r3= findViewById(R.id.c53);
        t3= findViewById(R.id.c63);
        u3= findViewById(R.id.c73);
        a3 = findViewById(R.id.c83);

        //kofradia
        k4 = findViewById(R.id.c35);
        o4 = findViewById(R.id.c45);
        f4 = findViewById(R.id.c55);
        r4 = findViewById(R.id.c65);
        a4 = findViewById(R.id.c75);
        d4 = findViewById(R.id.c85);
        i4 = findViewById(R.id.c95);
        a42 = findViewById(R.id.c105);

        // olatua
        o5 = findViewById(R.id.c41);
        l5 = findViewById(R.id.c51);
        a5 = findViewById(R.id.c61);
        t5 = findViewById(R.id.c71);
        u5 = findViewById(R.id.c81);
        a52 = findViewById(R.id.c91);

        //santurtzi
        s6 = findViewById(R.id.c60);
        n6 = findViewById(R.id.c62);
        u6 = findViewById(R.id.c64);
        t6 = findViewById(R.id.c66);
        i6 = findViewById(R.id.c68);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[0]);
                paraComprarar = respuestasCorrectas[0];
                cualBoton = 1;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[1]);
                paraComprarar = respuestasCorrectas[1];
                cualBoton = 2;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[2]);
                paraComprarar = respuestasCorrectas[2];
                cualBoton = 3;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[3]);
                paraComprarar = respuestasCorrectas[3];
                cualBoton = 4;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[4]);
                paraComprarar = respuestasCorrectas[4];
                cualBoton = 5;
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pista.setText(pistas[5]);
                paraComprarar = respuestasCorrectas[5];
                cualBoton = 6;
            }
        });
        comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(respuesta.getText().toString().toUpperCase().trim().equals(paraComprarar)){
                    llenar();
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
    public void llenar(){
        switch (cualBoton){
            case 1:
                i1.setText("I");
                t1.setText("T");
                s1.setText("S");
                a1.setText("A");
                s12.setText("S");
                o1.setText("O");
                a12.setText("A");
                btn1.setClickable(false);
                btn1.setBackgroundColor(getColor(R.color.azulSecundario));
                pista.setText("");
                cont++;
                if(cont == 6)
                    yaEsta();
                break;
            case 2:
                a12.setText("A");
                r2.setText("R");
                r22.setText("R");
                a2.setText("A");
                n2.setText("N");
                t2.setText("T");
                z2.setText("Z");
                a22.setText("A");
                l2.setText("L");
                e2.setText("E");
                a23.setText("A");
                btn2.setClickable(false);
                btn2.setBackgroundColor(getColor(R.color.azulSecundario));
                pista.setText("");
                cont++;
                if(cont == 6)
                    yaEsta();
                break;
            case 3:
                p3.setText("P");
                o3.setText("O");
                r3.setText("R");
                t3.setText("T");
                u3.setText("U");
                a3.setText("A");
                btn3.setClickable(false);
                btn3.setBackgroundColor(getColor(R.color.azulSecundario));
                pista.setText("");
                cont++;
                if(cont == 6)
                    yaEsta();
                break;
            case 4:
                k4.setText("K");
                o4.setText("O");
                f4.setText("F");
                r4.setText("R");
                a4.setText("A");
                d4.setText("D");
                i4.setText("I");
                a42.setText("A");
                btn4.setClickable(false);
                btn4.setBackgroundColor(getColor(R.color.azulSecundario));
                pista.setText("");
                cont++;
                if(cont == 6)
                    yaEsta();
                break;
            case 5:
                o5.setText("O");
                l5.setText("L");
                a5.setText("A");
                t5.setText("T");
                u5.setText("U");
                a52.setText("A");
                btn5.setClickable(false);
                btn5.setBackgroundColor(getColor(R.color.azulSecundario));
                pista.setText("");
                cont++;
                if(cont == 6)
                    yaEsta();
                break;
            case 6:
                s6.setText("S");
                a5.setText("A");
                n6.setText("N");
                t3.setText("T");
                u6.setText("U");
                r4.setText("R");
                t6.setText("T");
                z2.setText("Z");
                i6.setText("I");
                btn6.setClickable(false);
                btn6.setBackgroundColor(getColor(R.color.azulSecundario));
                pista.setText("");
                cont++;
                if(cont == 6)
                    yaEsta();
                break;
        }
    }
    public void yaEsta(){
        // la ha hecho bien, le damos una pieza
        Dialogo_gana_pieza_act4 d4 = new Dialogo_gana_pieza_act4();
        d4.show(getSupportFragmentManager(),"mensaje");
        ProgresoDao pd = new ProgresoDao();
        pd.setTrue(dinadbh,"Juego 4");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 10000);
    }
}