package com.example.sqlite_quanlysinhvien.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlite_quanlysinhvien.database.DbHelper;
import com.example.sqlite_quanlysinhvien.model.Sinhvien;

import java.util.ArrayList;
import java.util.List;

public class SinhvienDao {
    private DbHelper db;
    public SinhvienDao(Context context)
    {
       db = new DbHelper(context);

    }
    public List<Sinhvien>  getALL(){
        String sql="select * from Sinhvien";
        List<Sinhvien> sinhvienList = new ArrayList<Sinhvien>();
        SQLiteDatabase database=db.getReadableDatabase();
        Cursor cursor =database.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            int masv=cursor.getInt(0);
            String hoten =cursor.getString(1);
            int gioitinh =cursor.getInt(2);
            String sdt=cursor.getString(3);
            String email=cursor.getString(4);
            Sinhvien sv = new Sinhvien(masv,hoten,gioitinh,sdt,email);
            sinhvienList.add(sv);
            cursor.moveToNext();

        }
        return  sinhvienList;


    }
    public void AddSinhvien(Sinhvien sv){
        SQLiteDatabase database=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("hoten",sv.getHoten112());
        values.put("gioitinh",sv.getGioitinh112());
        values.put("dienthoai",sv.getDienthoai112());
        values.put("email",sv.getEmail112());
        database.insert("Sinhvien",null,values);

    }
    public void UpdateSinhvien(Sinhvien sv){
        SQLiteDatabase database=db.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("hoten",sv.getHoten112());
        values.put("gioitinh",sv.getGioitinh112());
        values.put("dienthoai",sv.getDienthoai112());
        values.put("email",sv.getEmail112());
        String masv=String.valueOf(sv.getMasv112());
        database.update("Sinhvien",values,"masv=?",new String[]{masv});

    }
    public int DeleteSinhvien(String masv) {
        SQLiteDatabase database = db.getWritableDatabase();
        return database.delete("Sinhvien", "masv=?", new String[]{masv});

    }
}
