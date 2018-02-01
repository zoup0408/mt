package com.gc.activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONException;
import org.json.JSONObject;

public class DBProvider {
    SQLiteDatabase database;
    DBHelper dbHelper;
    Context mContext;

    public static DBProvider getDBProvider(Context context) {
        return new DBProvider(context);
    }

    private DBProvider(Context context) {
        this.mContext = context;
        if (this.dbHelper == null) {
            this.dbHelper = DBHelper.getDbHelper(context);
        }
    }

    public void load(int paramInt) {
        try {
            this.database = this.dbHelper.getWritableDatabase();
            loadHeroInfo(this.database, paramInt);
            loadMap(database, paramInt);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
            return;
        } finally {
            if (this.database.isOpen())
                this.database.close();
        }

    }

    public void save(int paramInt) {
        try {
            this.database = this.dbHelper.getWritableDatabase();
            saveMap(this.database, paramInt);
            saveHeroInfo(this.database, paramInt);
            saveInfo(this.database, paramInt);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
            return;
        } finally {
            if (this.database.isOpen())
                this.database.close();
        }
    }

    public void loadMap(SQLiteDatabase db, int id) throws JSONException {
        Cursor cursor = this.database.rawQuery("select value from map where id = " + id, null);
        while (cursor.moveToNext()) {
            JSONObject json = new JSONObject(cursor.getString(cursor.getColumnIndex("value")));
            for (int i = 0; i < 15; i++) {
                JSONObject floor = json.getJSONObject(new StringBuilder(String.valueOf(i + 1)).toString());
                System.out.println(floor);
                for (int j = 0; j < Map.floor1.length; j++) {
                    for (int k = 0; k < Map.floor1[j].length; k++) {
                        Map.setMapInfo(i + 1, j, k, floor.getInt(String.valueOf((i + 1) + j + k)));
                    }
                }
            }
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
    }

    public void loadHeroInfo(SQLiteDatabase db, int id) throws Exception {
        Cursor cursor = this.database.rawQuery("select value from heroInfo where id = " + id, null);
        while (cursor.moveToNext()) {
            boolean z;
            JSONObject json = new JSONObject(cursor.getString(cursor.getColumnIndex("value")));
            Hero.left = Float.parseFloat(json.getString("left"));
            Hero.top = Float.parseFloat(json.getString("top"));
            Hero.direction = Integer.parseInt(json.getString("direction"));
            Hero.attack = Integer.parseInt(json.getString("attack"));
            Hero.defence = Integer.parseInt(json.getString("defence"));
            Hero.hp = Integer.parseInt(json.getString("hp"));
            Hero.exp = Integer.parseInt(json.getString("exp"));
            Hero.gold = Integer.parseInt(json.getString("gold"));
            Hero.yellowKey = Integer.parseInt(json.getString("yellowKey"));
            Hero.blueKey = Integer.parseInt(json.getString("blueKey"));
            Hero.redKey = Integer.parseInt(json.getString("redKey"));
            Hero.isSearch = Integer.parseInt(json.getString("isSearch")) == 1;
            if (Integer.parseInt(json.getString("isFly")) == 1) {
                z = true;
            } else {
                z = false;
            }
            Hero.isFly = z;
            Hero.maxFloor = Integer.parseInt(json.getString("maxFloor"));
            MySurfaceView.floor = Integer.parseInt(json.getString("floor"));
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
    }

    public void saveMap(SQLiteDatabase db, int id) throws JSONException {
        StringBuilder sql = new StringBuilder();
        db.execSQL("delete from map where id = " + id);
        JSONObject json = new JSONObject();
        for (int i = 0; i < 15; i++) {
            json.put(new StringBuilder(String.valueOf(i + 1)).toString(), getJsonFloor(i + 1));
        }
        sql.append("insert into map values (" + id + " , '" + json.toString() + "')");
        db.execSQL(sql.toString());
        sql.delete(0, sql.length());
    }

    public JSONObject getJsonFloor(int floor) throws JSONException {
        JSONObject json = new JSONObject();
        int[][] map = Map.getMap(floor);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                json.put(String.valueOf(floor + i + j), new StringBuilder(String.valueOf(map[i][j])).toString());
            }
        }
        return json;
    }

    public void saveHeroInfo(SQLiteDatabase db, int id) throws JSONException {
        int i;
        JSONObject json = new JSONObject();
        json.put("left", (double) Hero.left);
        json.put("top", (double) Hero.top);
        json.put("direction", Hero.direction);
        json.put("attack", Hero.attack);
        json.put("defence", Hero.defence);
        json.put("hp", Hero.hp);
        json.put("exp", Hero.exp);
        json.put("gold", Hero.gold);
        json.put("yellowKey", Hero.yellowKey);
        json.put("blueKey", Hero.blueKey);
        json.put("redKey", Hero.redKey);
        json.put("isSearch", Hero.isSearch ? 1 : 0);
        String str = "isFly";
        if (Hero.isFly) {
            i = 1;
        } else {
            i = 0;
        }
        json.put(str, i);
        json.put("maxFloor", Hero.maxFloor);
        json.put("floor", MySurfaceView.floor);
        db.execSQL("delete from heroInfo where id = " + id);
        db.execSQL("insert into heroInfo values (" + id + " , '" + json.toString() + "')");
    }

    public void saveInfo(SQLiteDatabase db, int id) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("date", DateUtil.getDateTime());
        json.put("floor", MySurfaceView.floor);
        json.put("attack", Hero.attack);
        json.put("defence", Hero.defence);
        json.put("hp", Hero.hp);
        db.execSQL("delete from info where id = " + id);
        System.out.println(json.toString());
        db.execSQL("insert into info values (" + id + " , '" + json.toString() + "')");
    }
}
