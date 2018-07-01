package com.example.jhonatashenrique.aulas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jhonatashenrique.aulas.Domain.Quinta;

public class QuintaDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "dbaulas";
    private static final int VERSION = 1;

    public QuintaDAO(Context context){
        super(context, DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelas = "CREATE TABLE quinta(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
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

    public void SalvarQuinta (Quinta quinta){
        ContentValues values = new ContentValues();

        values.put("horario1", quinta.getHorario1());
        values.put("horario2", quinta.getHorario2());
        values.put("horario3", quinta.getHorario3());
        values.put("horario4", quinta.getHorario4());
        values.put("horario5", quinta.getHorario5());
        values.put("horario6", quinta.getHorario6());
        values.put("aula1", quinta.getAula1());
        values.put("aula2", quinta.getAula2());
        values.put("aula3", quinta.getAula3());
        values.put("aula4", quinta.getAula4());
        values.put("aula5", quinta.getAula5());
        values.put("aula6", quinta.getAula6());


        getWritableDatabase().insert("quinta", null, values);

    }

    public void alteraQuinta (Quinta quinta){
        ContentValues values = new ContentValues();

        values.put("horario1", quinta.getHorario1());
        values.put("horario2", quinta.getHorario2());
        values.put("horario3", quinta.getHorario3());
        values.put("horario4", quinta.getHorario4());
        values.put("horario5", quinta.getHorario5());
        values.put("horario6", quinta.getHorario6());
        values.put("aula1", quinta.getAula1());
        values.put("aula2", quinta.getAula2());
        values.put("aula3", quinta.getAula3());
        values.put("aula4", quinta.getAula4());
        values.put("aula5", quinta.getAula5());
        values.put("aula6", quinta.getAula6());

        String[] arg = {"1"};

        getWritableDatabase().update("quinta", values, "id=?", arg);
    }

    public void deletaQuinta (Quinta quinta){
        String[] arg = {String.valueOf(quinta.getId())};
        getWritableDatabase().delete("quinta", "id=?", arg);
    }

    public Quinta buscarQuinta (){
        //String[] arg = {String.valueOf(quinta.getId())};
        String [] columns = {"id", "horario1", "horario2", "horario3", "horario4", "horario5", "horario6", "aula1", "aula2",
                "aula3", "aula4", "aula5", "aula6"};
        Quinta seg = new Quinta();
        Cursor cursor = getWritableDatabase().query("quinta", columns, null, null,null, null, null, null);
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