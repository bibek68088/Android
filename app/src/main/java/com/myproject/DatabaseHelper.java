package com.myproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    static String name = "bca6";
    static int version = 1;
    String createTableUser = "CREATE TABLE if not EXISTS \"user\" (\n" +
            "\t\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t\"username\"\tTEXT NOT NULL,\n" +
            "\t\"password\"\tTEXT NOT NULL,\n" +
            "\t\"firstname\"\tTEXT,\n" +
            "\t\"lastname\"\tTEXT,\n" +
            "\t\"email\"\tTEXT NOT NULL,\n" +
            "\t\"phone\"\tTEXT,\n" +
            "\t\"image\"\tBLOB \n" +
            ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, name, null, version);

        getWritableDatabase().execSQL(createTableUser);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void insertUser(ContentValues values) {
        getWritableDatabase().insert("user", "", values);
    }

    public void updateUser(ContentValues contentValues, String id) {
        getWritableDatabase().update("user", contentValues, "id=" + id, null);
    }

    public void deleteUser(String id) {
        getWritableDatabase().delete("user", "id=?", new String[]{id});
    }

    @SuppressLint("Range")
    public ArrayList<Userinfo> getUsers() {
        String sql = "select * from user";
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        ArrayList<Userinfo> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Userinfo info = new Userinfo();
            info.id = cursor.getString(cursor.getColumnIndex("id"));
            info.username = cursor.getString(cursor.getColumnIndex("username"));
            info.password = cursor.getString(cursor.getColumnIndex("password"));
            info.email = cursor.getString(cursor.getColumnIndex("email"));
//            info.address = cursor.getString(cursor.getColumnIndex("address"));
            info.firstname = cursor.getString(cursor.getColumnIndex("firstname"));
            info.lastname = cursor.getString(cursor.getColumnIndex("lastname"));
            info.image = cursor.getBlob(cursor.getColumnIndex("image"));
            list.add(info);
        }
        return list;
    }

    @SuppressLint("Range")
    public Userinfo getUserInfo(String id) {
        String sql = "select * from user where id =?";
        Log.i("sql:", sql);
        Cursor cursor = getWritableDatabase().rawQuery(sql, new String[]{id});
        Userinfo info = new Userinfo();
        while (cursor.moveToNext()) {
            info.id = cursor.getString(cursor.getColumnIndex("id"));
            info.username = cursor.getString(cursor.getColumnIndex("username"));
            info.password = cursor.getString(cursor.getColumnIndex("password"));
            info.email = cursor.getString(cursor.getColumnIndex("email"));
//            info.address = cursor.getString(cursor.getColumnIndex("address"));
            info.image = cursor.getBlob(cursor.getColumnIndex("image"));
            info.firstname = cursor.getString(cursor.getColumnIndex("firstname"));
            info.lastname = cursor.getString(cursor.getColumnIndex("lastname"));
        }
        return info;
    }
}
