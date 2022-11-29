package com.example.dina;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProgresoDao {



    public boolean crearBBDD(HechosSQLiteHelper dinadbh) {

        SQLiteDatabase db = dinadbh.getWritableDatabase();
        if (db != null){
            for (int i =1; i<=7; i++){
                String nombre ="Juego "+i;
                db.execSQL("INSERT INTO Progreso (juego, hecho)" +
                        " VALUES ('"+nombre+"','false') ");
            }
        }
        db.close();
        return true;
    }

    public void setTrue(HechosSQLiteHelper dinadbh, String nombre){
        SQLiteDatabase db = dinadbh.getWritableDatabase();
        if (db != null) {
            db.execSQL("UPDATE Progreso SET hecho='true' WHERE juego='" + nombre+"'");
        }
        db.close();
    }

    public void juegoNuevo(HechosSQLiteHelper dinadbh){
        SQLiteDatabase db = dinadbh.getWritableDatabase();
        if(db != null) {
            db.execSQL("UPDATE Progreso SET hecho='false'");
        }
        db.close();
    }

    public int cuantosJuegosHechos(HechosSQLiteHelper dinadbh){
        int cuantos = 0;
        SQLiteDatabase db = dinadbh.getReadableDatabase();
        if(db != null) {
            Cursor c = db.rawQuery("SELECT juego FROM Progreso " +
                    "WHERE hecho = 'true'", null);
            cuantos = c.getCount();
            c.close();
        }
        db.close();
        return cuantos;
    }
}
