package tdc.edu.vn.myapplication.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Model.CongNhan;

public class DBCongNhan {
    DBHelper dbHelper;

    public DBCongNhan(Context context) {
       dbHelper= new DBHelper(context);
    }

    public void Them(CongNhan congNhan)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("macn",congNhan.getMaCN());
        values.put("hoten",congNhan.getTenCN());
        values.put("phanxuong",congNhan.getPhanXuong());
        db.insert("CongNhan",null,values);
    }

    public  void Sua(CongNhan congNhan)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("macn", congNhan.getMaCN());
        values.put("hoten", congNhan.getTenCN());
        values.put("phanxuong", congNhan.getPhanXuong());
        db.update("CongNhan",values,"macn ='"+ congNhan.getMaCN() +"'",null);
    }


    public  void Xoa(CongNhan congNhan)
    {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql ="Delete from CongNhan where macn= '"+ congNhan.getMaCN()+"'";
        db.execSQL(sql);

    }

    public ArrayList<CongNhan> LayDL()
    {
        ArrayList<CongNhan> data = new ArrayList<>();
        String sql="select * from CongNhan";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try {
            cursor.moveToFirst();
            do {
                CongNhan congNhan = new CongNhan();
                congNhan.setMaCN(cursor.getString(0));
                congNhan.setTenCN(cursor.getString(1));
                congNhan.setPhanXuong(cursor.getString(2));
                data.add(congNhan);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {

        }
        return  data;
    }


    public ArrayList<CongNhan> LayDL(String ma)
    {
        ArrayList<CongNhan> data = new ArrayList<>();
        String sql="select * from CongNhan where macn = '"+ma+"'";
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        try {
            cursor.moveToFirst();
            do {
                CongNhan congNhan = new CongNhan();
                congNhan.setMaCN(cursor.getString(0));
                congNhan.setTenCN(cursor.getString(1));
                congNhan.setPhanXuong(cursor.getString(2));
                data.add(congNhan);
            }
            while (cursor.moveToNext());
        }
        catch (Exception ex)
        {

        }
        return  data;
    }
}
