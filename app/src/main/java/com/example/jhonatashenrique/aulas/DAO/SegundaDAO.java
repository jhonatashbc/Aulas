package com.example.jhonatashenrique.aulas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jhonatashenrique.aulas.Domain.Segunda;

public class SegundaDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "dbaulas";
    private static final int VERSION = 1;

    public SegundaDAO(Context context){
        super(context, DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelas = "CREATE TABLE segunda(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "horario1 INTEGER," +
                "horario2 INTEGER," +
                "horario3 INTEGER," +
                "horario4 INTEGER," +
                "horario5 INTEGER," +
                "horario6 INTEGER," +
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
                "FOREIGN KEY(aula6) REFERENCES materia(id)," +
                "FOREIGN KEY(horario1) REFERENCES horario(id)," +
                "FOREIGN KEY(horario2) REFERENCES horario(id)," +
                "FOREIGN KEY(horario3) REFERENCES horario(id)," +
                "FOREIGN KEY(horario4) REFERENCES horario(id)," +
                "FOREIGN KEY(horario5) REFERENCES horario(id)," +
                "FOREIGN KEY(horario6) REFERENCES horario(id));";

      String  tabelas2 = "CREATE TABLE terca(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "horario1 INTEGER," +
                "horario2 INTEGER," +
                "horario3 INTEGER," +
                "horario4 INTEGER," +
                "horario5 INTEGER," +
                "horario6 INTEGER," +
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
              "FOREIGN KEY(aula6) REFERENCES materia(id)," +
              "FOREIGN KEY(horario1) REFERENCES horario(id)," +
              "FOREIGN KEY(horario2) REFERENCES horario(id)," +
              "FOREIGN KEY(horario3) REFERENCES horario(id)," +
              "FOREIGN KEY(horario4) REFERENCES horario(id)," +
              "FOREIGN KEY(horario5) REFERENCES horario(id)," +
              "FOREIGN KEY(horario6) REFERENCES horario(id));";

        String tabelas3 = "CREATE TABLE quarta(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "horario1 INTEGER" +
                ",horario2 INTEGER," +
                "horario3 INTEGER," +
                "horario4 INTEGER," +
                "horario5 INTEGER," +
                "horario6 INTEGER," +
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
                "FOREIGN KEY(aula6) REFERENCES materia(id)," +
                "FOREIGN KEY(horario1) REFERENCES horario(id)," +
                "FOREIGN KEY(horario2) REFERENCES horario(id)," +
                "FOREIGN KEY(horario3) REFERENCES horario(id)," +
                "FOREIGN KEY(horario4) REFERENCES horario(id)," +
                "FOREIGN KEY(horario5) REFERENCES horario(id)," +
                "FOREIGN KEY(horario6) REFERENCES horario(id));";

        String tabelas4 = "CREATE TABLE quinta(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "horario1 INTEGER," +
                "horario2 INTEGER," +
                "horario3 INTEGER," +
                "horario4 INTEGER," +
                "horario5 INTEGER," +
                "horario6 INTEGER," +
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
                "FOREIGN KEY(aula6) REFERENCES materia(id)," +
                "FOREIGN KEY(horario1) REFERENCES horario(id)," +
                "FOREIGN KEY(horario2) REFERENCES horario(id)," +
                "FOREIGN KEY(horario3) REFERENCES horario(id)," +
                "FOREIGN KEY(horario4) REFERENCES horario(id)," +
                "FOREIGN KEY(horario5) REFERENCES horario(id)," +
                "FOREIGN KEY(horario6) REFERENCES horario(id));";

        String tabelas5 = "CREATE TABLE sexta(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "horario1 INTEGER," +
                "horario2 INTEGER," +
                "horario3 INTEGER," +
                "horario4 INTEGER," +
                "horario5 INTEGER," +
                "horario6 INTEGER," +
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
                "FOREIGN KEY(aula6) REFERENCES materia(id)," +
                "FOREIGN KEY(horario1) REFERENCES horario(id)," +
                "FOREIGN KEY(horario2) REFERENCES horario(id)," +
                "FOREIGN KEY(horario3) REFERENCES horario(id)," +
                "FOREIGN KEY(horario4) REFERENCES horario(id)," +
                "FOREIGN KEY(horario5) REFERENCES horario(id)," +
                "FOREIGN KEY(horario6) REFERENCES horario(id));";

        String tabelas6 = "CREATE TABLE materia(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nome TEXT," +
                "falta INTEGER," +
                "presenca INTEGER" +
                ");";

        String tabelas7 = "CREATE TABLE faltas(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "id_materia INTEGER," +
                "nomemat TEXT," +
                "dia INTEGER," +
                "mes INTEGER," +
                "FOREIGN KEY(id_materia) REFERENCES materia(id)" +
                ");";
        String tabelas8 = "CREATE TABLE horario(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "horario1 TEXT," +
                "horario2 TEXT," +
                "horario3 TEXT," +
                "horario4 TEXT," +
                "horario5 TEXT," +
                "horario6 TEXT);";
        String tabelas9 = "CREATE TABLE checkinaula(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "checkaula1 INTEGER," +
                "checkaula2 INTEGER," +
                "checkaula3 INTEGER," +
                "checkaula4 INTEGER," +
                "checkaula5 INTEGER," +
                "checkaula6 INTEGER);";

        db.execSQL(tabelas);
        db.execSQL(tabelas2);
        db.execSQL(tabelas3);
        db.execSQL(tabelas4);
        db.execSQL(tabelas5);
        db.execSQL(tabelas6);
        db.execSQL(tabelas7);
        db.execSQL(tabelas8);
        db.execSQL(tabelas9);
    }

    public void SalvarSegunda (Segunda segunda){
        ContentValues values = new ContentValues();

        values.put("horario1", segunda.getHorario1());
        values.put("horario2", segunda.getHorario2());
        values.put("horario3", segunda.getHorario3());
        values.put("horario4", segunda.getHorario4());
        values.put("horario5", segunda.getHorario5());
        values.put("horario6", segunda.getHorario6());
        values.put("aula1", segunda.getAula1());
        values.put("aula2", segunda.getAula2());
        values.put("aula3", segunda.getAula3());
        values.put("aula4", segunda.getAula4());
        values.put("aula5", segunda.getAula5());
        values.put("aula6", segunda.getAula6());


        getWritableDatabase().insert("segunda", null, values);

    }

    public void alteraSegunda (Segunda segunda){
        ContentValues values = new ContentValues();

        values.put("horario1", segunda.getHorario1());
        values.put("horario2", segunda.getHorario2());
        values.put("horario3", segunda.getHorario3());
        values.put("horario4", segunda.getHorario4());
        values.put("horario5", segunda.getHorario5());
        values.put("horario6", segunda.getHorario6());
        values.put("aula1", segunda.getAula1());
        values.put("aula2", segunda.getAula2());
        values.put("aula3", segunda.getAula3());
        values.put("aula4", segunda.getAula4());
        values.put("aula5", segunda.getAula5());
        values.put("aula6", segunda.getAula6());

        String[] arg = {"1"};

        getWritableDatabase().update("segunda", values, "id=?", arg);
    }

    public void deletaSegunda (Segunda segunda){
        String[] arg = {String.valueOf(segunda.getId())};
        getWritableDatabase().delete("segunda", "id=?", arg);
    }

    public Segunda buscarSegunda (){
        //String[] arg = {String.valueOf(segunda.getId())};
        String [] columns = {"id", "horario1", "horario2", "horario3", "horario4", "horario5", "horario6", "aula1", "aula2",
                "aula3", "aula4", "aula5", "aula6"};
        Segunda seg = new Segunda();
        Cursor cursor = getWritableDatabase().query("segunda", columns, null, null,null, null, null, null);
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
