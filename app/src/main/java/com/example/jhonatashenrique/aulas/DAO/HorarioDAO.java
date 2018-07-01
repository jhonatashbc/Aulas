package com.example.jhonatashenrique.aulas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jhonatashenrique.aulas.Domain.Horario;

public class HorarioDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "dbaulas";
    private static final int VERSION = 1;

    public HorarioDAO(Context context){
        super(context, DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelas = "CREATE TABLE horario(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "horario1 TEXT," +
                "horario2 TEXT," +
                "horario3 TEXT," +
                "horario4 TEXT," +
                "horario5 TEXT," +
                "horario6 TEXT);";


        db.execSQL(tabelas);
    }

    public void SalvarHorario (Horario horario){
        ContentValues values = new ContentValues();

        values.put("horario1", horario.getHorario1());
        values.put("horario2", horario.getHorario2());
        values.put("horario3", horario.getHorario3());
        values.put("horario4", horario.getHorario4());
        values.put("horario5", horario.getHorario5());
        values.put("horario6", horario.getHorario6());


        getWritableDatabase().insert("horario", null, values);

    }

    public void alteraHorario (Horario horario){
        ContentValues values = new ContentValues();

        values.put("horario1", horario.getHorario1());
        values.put("horario2", horario.getHorario2());
        values.put("horario3", horario.getHorario3());
        values.put("horario4", horario.getHorario4());
        values.put("horario5", horario.getHorario5());
        values.put("horario6", horario.getHorario6());

        String[] arg = {"1"};

        getWritableDatabase().update("horario", values, "id=?", arg);
    }

    public void deletaHorario (Horario horario){
        String[] arg = {String.valueOf(horario.getId())};
        getWritableDatabase().delete("horario", "id=?", arg);
    }

    public Horario buscarHorario (){
        //String[] arg = {String.valueOf(horario.getId())};
        String [] columns = {"id", "horario1", "horario2", "horario3", "horario4", "horario5", "horario6"};
        Horario seg = new Horario();
        Cursor cursor = getWritableDatabase().query("horario", columns, null, null,null, null, null, null);
        while (cursor.moveToNext()) {
            seg.setId(cursor.getLong(0));
            seg.setHorario1(cursor.getString(1));
            seg.setHorario2(cursor.getString(2));
            seg.setHorario3(cursor.getString(3));
            seg.setHorario4(cursor.getString(4));
            seg.setHorario5(cursor.getString(5));
            seg.setHorario6(cursor.getString(6));
        }

        return seg;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
