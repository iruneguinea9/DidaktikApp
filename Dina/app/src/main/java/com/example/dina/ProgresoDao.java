package com.example.dina;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class ProgresoDao extends AppCompatActivity {

    private HechosSQLiteHelper dinadbh =
            new HechosSQLiteHelper(this, "DBDina", null, 1);

    public boolean crearBBDD() {

        SQLiteDatabase db = dinadbh.getWritableDatabase();
        if (db != null){
            for (int i =1; i<=7; i++){
                String nombre ="Juego "+i;
                db.execSQL("INSERT INTO Progreso (juego, hecho)" +
                        " VALUES (nombre,'false') ");
            }
        }
        db.close();
        return true;
    }

    public void setTrue(String nombre){
        SQLiteDatabase db = dinadbh.getWritableDatabase();
        if (db != null) {
            db.execSQL("UPDATE Progreso SET hecho='true' WHERE juego=" + nombre);
        }
        db.close();
    }

    public void juegoNuevo(){
        SQLiteDatabase db = dinadbh.getWritableDatabase();
        if(db != null) {
            db.execSQL("UPDATE Progreso SET hecho='false'");
        }
        db.close();
    }

    public int cuantosJuegosHechos(){
        int cuantos = 0;
        SQLiteDatabase db = dinadbh.getWritableDatabase();
        if(db != null) {
            Cursor c = db.rawQuery("SELECT juego FROM Progreso " +
                    "WHERE hecho = 'true'", null);
            cuantos = c.getCount();
        }
        db.close();
        return cuantos;
    }
}
