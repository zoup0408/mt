package com.gc.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String dbname = "MagicTower";

    private DBHelper(Context context) {
        super(context, dbname, null, 1);
    }

    public static DBHelper getDbHelper(Context context) {
        return new DBHelper(context);
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            System.out.println("???????????????????????????????111");
            db.execSQL("create table map(id integer,value text)");
            db.execSQL("create table heroInfo(id integer,value text)");
            db.execSQL("create table info(id integer,value text)");
            System.out.println("------------------------------222");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
    }
}
