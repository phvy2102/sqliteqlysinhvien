package com.example.sqlite_quanlysinhvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper( Context context) {
        super(context, "QLSinhvien.sqlite", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreate="Create table if not exists Sinhvien(masv integer primary key autoincrement,hoten nvarchar(200),gioitinh integer,dienthoai nvarchar(200),email nvarchar(200))";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
