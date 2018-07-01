package com.example.jhonatashenrique.aulas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jhonatashenrique.aulas.Domain.Terca;

public class TercaDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "dbaulas";
    private static final int VERSION = 1;

    public TercaDAO(Context context){
        super(context, DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelas = "CREATE TABLE terca(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "horario1 TEXT," +
                "horario2 TEXT," +
                "horario3 TEXT," +
                "horario4 TEXT," +
                "horario5 TEXT," +
                "horario6 TEXT," +
                "aula1 INTEGER," +
                "aula2 INTEGER," +
                "aula3 INTEGER," +
                "aula4 INTEGER," +
                "aula5 INTEGER," +
                "aula6 INTEGER," +
                "FOREIGN KEY(aula1) REFERENCES materia(id)," +
                "FOREIGN KEY(aula2) REFERENCES materia(id)," +
                "FOREIGN KEY(aula3) REFERENCES materia(id)," +
                "FOREIGN KEY(aula4) REFERENCES materia(id)," +
                "FOREIGN KEY(aula5) REFERENCES materia(id)," +
                "FOREIGN KEY(aula6) REFERENCES materia(id));";
        db.execSQL(tabelas);

    }

    public void SalvarTerca (Terca terca){
        ContentValues values = new ContentValues();

        values.put("horario1", terca.getHorario1());
        values.put("horario2", terca.getHorario2());
        values.put("horario3", terca.getHorario3());
        values.put("horario4", terca.getHorario4());
        values.put("horario5", terca.getHorario5());
        values.put("horario6", terca.getHorario6());
        values.put("aula1", terca.getAula1());
        values.put("aula2", terca.getAula2());
        values.put("aula3", terca.getAula3());
        values.put("aula4", terca.getAula4());
        values.put("aula5", terca.getAula5());
        values.put("aula6", terca.getAula6());


        getWritableDatabase().insert("terca", null, values);

    }

    public void alteraTerca (Terca terca){
        ContentValues values = new ContentValues();

        values.put("horario1", terca.getHorario1());
        values.put("horario2", terca.getHorario2());
        values.put("horario3", terca.getHorario3());
        values.put("horario4", terca.getHorario4());
        values.put("horario5", terca.getHorario5());
        values.put("horario6", terca.getHorario6());
        values.put("aula1", terca.getAula1());
        values.put("aula2", terca.getAula2());
        values.put("aula3", terca.getAula3());
        values.put("aula4", terca.getAula4());
        values.put("aula5", terca.getAula5());
        values.put("aula6", terca.getAula6());

        String[] arg = {"1"};

        getWritableDatabase().update("terca", values, "id=?", arg);
    }

    public void deletaTerca (Terca terca){
        String[] arg = {String.valueOf(terca.getId())};
        getWritableDatabase().delete("terca", "id=?", arg);
    }

    public Terca buscarTerca (){
        //String[] arg = {String.valueOf(terca.getId())};
        String [] columns = {"id", "horario1", "horario2", "horario3", "horario4", "horario5", "horario6", "aula1", "aula2",
                "aula3", "aula4", "aula5", "aula6"};
        Terca seg = new Terca();
        Cursor cursor = getWritableDatabase().query("terca", columns, null, null,null, null, null, null);
        while (cursor.moveToNext()) {
            seg.setId(cursor.getLong(0));
            seg.setHorario1(cursor.getLong(1));
            seg.setHorario2(cursor.getLong(2));
            seg.setHorario3(cursor.getLong(3));
            seg.setHorario4(cursor.getLong(4));
            seg.setHorario5(cursor.getLong(5));
            seg.setHorario6(cursor.getLong(6));
            seg.setAula1(cursor.getLong(7));
            seg.setAula2(cursor.getLong(8));
            seg.setAula3(cursor.getLong(9));
            seg.setAula4(cursor.getLong(10));
            seg.setAula5(cursor.getLong(11));
            seg.setAula6(cursor.getLong(12));
        }

        return seg;
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}