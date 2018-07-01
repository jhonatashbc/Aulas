package com.example.jhonatashenrique.aulas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jhonatashenrique.aulas.Domain.Faltas;
import com.example.jhonatashenrique.aulas.Domain.Materia;

import java.util.ArrayList;

public class FaltasDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "dbaulas";
    private static final int VERSION = 1;

    public FaltasDAO(Context context){
        super(context, DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelas = "CREATE TABLE faltas(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "id_materia INTEGER," +
                "nomemat TEXT," +
                "dia INTEGER," +
                "mes INTEGER," +
                "FOREIGN KEY(id_materia) REFERENCES materia(id)" +
                ");";
        db.execSQL(tabelas);

    }

    public void SalvarFaltas (Faltas faltas){
        ContentValues values = new ContentValues();

        values.put("id_materia", faltas.getId_materia() );
        values.put("nomemat", faltas.getNomeMat());
        values.put("dia", faltas.getDia());
        values.put("mes", faltas.getMes());


        getWritableDatabase().insert("faltas", null, values);

    }

    public void alteraFaltas (Faltas faltas){
        ContentValues values = new ContentValues();

        values.put("id_materia", faltas.getId_materia() );
        values.put("nomemat", faltas.getNomeMat());
        values.put("dia", faltas.getDia());
        values.put("mes", faltas.getMes());

        String[] arg = {""+faltas.getId()};

        getWritableDatabase().update("faltas", values, "id=?", arg);
    }

    public void deletaFaltas (Faltas faltas){
        String[] arg = {String.valueOf(faltas.getId())};
        getWritableDatabase().delete("faltas", "id=?", arg);
    }

    public ArrayList<Faltas> buscarFaltas (){
        String [] columns = {"id", "id_materia", "nomemat", "dia", "mes"};
        Faltas falt = new Faltas();
        Cursor cursor = getWritableDatabase().query("faltas", columns, null, null,null, null, null, null);

        ArrayList<Faltas> falta = new ArrayList<>();
        while (cursor.moveToNext()) {
            falt.setId(cursor.getLong(0));
            falt.setId_materia(cursor.getLong(1));
            falt.setNomeMat(cursor.getString(2));
            falt.setDia(cursor.getInt(3));
            falt.setMes(cursor.getInt(4));

            falta.add(falt);
        }

        return falta;
    }

    public ArrayList<Faltas> buscarFaltas (long longer){
        String [] where= {""+longer};
        String [] columns = {"id", "id_materia", "nomemat", "dia", "mes"};

        Cursor cursor = getWritableDatabase().query("faltas", columns, "id_materia=?", where,null, null, null, null);

        ArrayList<Faltas> falta = new ArrayList<>();
        while (cursor.moveToNext()) {
            Faltas falt = new Faltas();
            falt.setId(cursor.getLong(0));
            falt.setId_materia(cursor.getLong(1));
            falt.setNomeMat(cursor.getString(2));
            falt.setDia(cursor.getInt(3));
            falt.setMes(cursor.getInt(4));

            falta.add(falt);
        }

        return falta;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}