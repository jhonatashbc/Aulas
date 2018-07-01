package com.example.jhonatashenrique.aulas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jhonatashenrique.aulas.Domain.Faltas;
import com.example.jhonatashenrique.aulas.Domain.Materia;
import com.example.jhonatashenrique.aulas.Domain.Terca;

import java.util.ArrayList;
import java.util.List;

public class MateriaDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "dbaulas";
    private static final int VERSION = 1;

    public MateriaDAO(Context context){
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelas = "CREATE TABLE materia(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "nome TEXT," +
                "falta INTEGER," +
                "presenca INTEGER" +
                ");";
        db.execSQL(tabelas);

    }

    public void SalvarMeteria (Materia materia){
        ContentValues values = new ContentValues();

        values.put("nome", materia.getNome());
        values.put("falta", materia.getFalta());
        values.put("presenca", materia.getPresenca());


        getWritableDatabase().insert("materia", null, values);

    }

    public void alteraMateria (Materia materia){
        ContentValues values = new ContentValues();

        values.put("nome", materia.getNome());
        values.put("falta", materia.getFalta());
        values.put("presenca", materia.getPresenca());

        String[] arg = {""+materia.getId()};

        getWritableDatabase().update("materia", values, "id=?", arg);
    }

    public void deletaMateria (Materia materia){
        String[] arg = {String.valueOf(materia.getId())};
        getWritableDatabase().delete("materia", "id=?", arg);
    }

    public List<Materia> buscarMateria (){
        String [] columns = {"id", "nome", "falta", "presenca"};
        Cursor cursor = getWritableDatabase().query("materia", columns, null, null,null, null, null, null);

        ArrayList<Materia> materia = new ArrayList<>();
        while (cursor.moveToNext()) {
            Materia mat = new Materia();
            mat.setId(cursor.getLong(0));
            mat.setNome(cursor.getString(1));
            mat.setFalta(cursor.getInt(2));
            mat.setPresenca(cursor.getInt(3));

            materia.add(mat);
        }

        return materia;
    }

    public Materia buscarMateria (long longer){
        String [] where= {""+longer};
        String [] columns = {"id", "nome", "falta", "presenca"};

        Cursor cursor = getWritableDatabase().query("materia", columns, "id=?", where,null, null, null, null);

        Materia mat = new Materia();
        while (cursor.moveToNext()) {

            mat.setId(cursor.getLong(0));
            mat.setNome(cursor.getString(1));
            mat.setFalta(cursor.getInt(2));
            mat.setPresenca(cursor.getInt(3));
        }

        return mat;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}