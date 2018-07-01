package com.example.jhonatashenrique.aulas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jhonatashenrique.aulas.Domain.CheckInAula;

public class CheckInAulaDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "dbaulas";
    private static final int VERSION = 1;

    public CheckInAulaDAO(Context context){
        super(context, DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabelas = "CREATE TABLE checkinaula(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "checkaula1 INTEGER," +
                "checkaula2 INTEGER," +
                "checkaula3 INTEGER," +
                "checkaula4 INTEGER," +
                "checkaula5 INTEGER," +
                "checkaula6 INTEGER);";
        db.execSQL(tabelas);

    }

    public void SalvarCheckInAula (CheckInAula checkInAula){
        ContentValues values = new ContentValues();

        values.put("checkaula1", checkInAula.getCheckaula1());
        values.put("checkaula2", checkInAula.getCheckaula2());
        values.put("checkaula3", checkInAula.getCheckaula3());
        values.put("checkaula4", checkInAula.getCheckaula4());
        values.put("checkaula5", checkInAula.getCheckaula5());
        values.put("checkaula6", checkInAula.getCheckaula6());


        getWritableDatabase().insert("checkinaula", null, values);

    }

    public void alteraCheckInAula (CheckInAula checkInAula){
        ContentValues values = new ContentValues();

        values.put("checkaula1", checkInAula.getCheckaula1());
        values.put("checkaula2", checkInAula.getCheckaula2());
        values.put("checkaula3", checkInAula.getCheckaula3());
        values.put("checkaula4", checkInAula.getCheckaula4());
        values.put("checkaula5", checkInAula.getCheckaula5());
        values.put("checkaula6", checkInAula.getCheckaula6());

        String[] arg = {"1"};

        getWritableDatabase().update("checkinaula", values, "id=?", arg);
    }

    public CheckInAula buscarCheckInAula (){
        //String[] arg = {String.valueOf(checkInAula.getId())};
        String [] columns = {"id", "checkaula1", "checkaula2", "checkaula3", "checkaula4", "checkaula5", "checkaula6"};
        CheckInAula seg = new CheckInAula();
        Cursor cursor = getWritableDatabase().query("checkInAula", columns, null, null,null, null, null, null);
        while (cursor.moveToNext()) {
            seg.setId(cursor.getLong(0));
            seg.setCheckaula1(cursor.getInt(1));
            seg.setCheckaula2(cursor.getInt(2));
            seg.setCheckaula3(cursor.getInt(3));
            seg.setCheckaula4(cursor.getInt(4));
            seg.setCheckaula5(cursor.getInt(5));
            seg.setCheckaula6(cursor.getInt(6));
        }

        return seg;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
