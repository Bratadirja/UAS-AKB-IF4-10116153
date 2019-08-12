package com.example.andikabratadirja.biodata.model.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

/*

 Tanggal Pengerjaan : 11-08-2019
 NIM : 10116153
 NAMA : Andika Bratadirja SJ
 KELAS : IF - 4

 */

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "biodata.db";

    //DATABASE UNTUK TEMAN
    public static final String TABLE_NAME = "teman";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NIM = "nim";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_KELAS = "kelas";
    public static final String COLUMN_TELP = "telp";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_INSTAGRAM = "instagram";
    public static final String COLUMN_FACEBOOK = "facebook";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, " +
                COLUMN_NIM + " TEXT  NOT NULL, " +
                COLUMN_NAMA + " TEXT NOT NULL," +
                COLUMN_KELAS + " TEXT NOT NULL," +
                COLUMN_TELP + " TEXT NOT NULL," +
                COLUMN_EMAIL + " TEXT NOT NULL," +
                COLUMN_INSTAGRAM + " TEXT NOT NULL," +
                COLUMN_FACEBOOK + " TEXT NOT NULL" +
                " )";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //QUERY UNTUK DATABASE TEMAN

    public ArrayList<HashMap<String, String>> getAllData() {
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_NIM, cursor.getString(1));
                map.put(COLUMN_NAMA, cursor.getString(2));
                map.put(COLUMN_KELAS, cursor.getString(3));
                map.put(COLUMN_TELP, cursor.getString(4));
                map.put(COLUMN_EMAIL, cursor.getString(5));
                map.put(COLUMN_INSTAGRAM, cursor.getString(6));
                map.put(COLUMN_FACEBOOK, cursor.getString(7));
                wordList.add(map);
            } while (cursor.moveToNext());
        }

        Log.e("select sqlite ", "" + wordList);

        database.close();
        return wordList;
    }

    public void insert(String nim, String nama, String kelas, String telp, String email, String instagram, String facebook) {
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO " + TABLE_NAME + " (nim, nama, kelas, telp, email, instagram, facebook) " +
                "VALUES ('" + nim + "', '" + nama + "', '" + kelas + "', '" + telp + "', '" + email + "', '" + instagram + "', '" + facebook + "')";

        Log.e("insert sqlite ", "" + queryValues);
        database.execSQL(queryValues);
        database.close();
    }

    public void update(int id, String nim, String nama, String kelas, String telp, String email, String instagram, String facebook) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "UPDATE " + TABLE_NAME + " SET "
                + COLUMN_NIM + "='" + nim + "', "
                + COLUMN_NAMA + "='" + nama + "',"
                + COLUMN_KELAS + "='" + kelas + "',"
                + COLUMN_TELP + "='" + telp + "',"
                + COLUMN_EMAIL + "='" + email + "',"
                + COLUMN_INSTAGRAM + "='" + instagram + "',"
                + COLUMN_FACEBOOK + "='" + facebook + "'"
                + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete(int id) {
        SQLiteDatabase database = this.getWritableDatabase();

        String updateQuery = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        Log.e("update sqlite ", updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }
}
