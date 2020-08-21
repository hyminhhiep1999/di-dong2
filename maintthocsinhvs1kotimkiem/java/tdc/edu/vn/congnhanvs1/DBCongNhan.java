package tdc.edu.vn.congnhanvs1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBCongNhan {
    DBhelper dBhelper;

    public DBCongNhan(Context context) {
        dBhelper = new DBhelper(context);
    }

    public void Them(CongNhan congNhan) {
        //ngayChamCong text, soSanPham text,loaiCongNhan text,loaiSanPham text
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ngayChamCong", congNhan.getNgayChamCong());
        values.put("soSanPham", congNhan.getSoSanPham());
        values.put("loaiCongNhan", congNhan.getLoaiCongNhan());
        values.put("loaiSanPham", congNhan.getLoaiSanPham());
        db.insert("CongNhan", null, values);
    }

    public void Xoa(CongNhan congNhan) {
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        String sql = "Delete from CongNhan where ngayChamCong ='" + congNhan.getNgayChamCong() + "'";
        db.execSQL(sql);
    }

    public void Sua(CongNhan congNhan) {
        SQLiteDatabase db = dBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ngayChamCong", congNhan.getNgayChamCong());
        values.put("soSanPham", congNhan.getSoSanPham());
        values.put("loaiCongNhan", congNhan.getLoaiCongNhan());
        values.put("loaiSanPham", congNhan.getLoaiSanPham());
        db.update("CongNhan",values,"ngayChamCong='" + congNhan.getNgayChamCong()+"'",null);
    }
    public ArrayList<CongNhan> getDuLieu(){
        ArrayList<CongNhan>data= new ArrayList<>();
        String sql = "select * from CongNhan";
        SQLiteDatabase db =dBhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
       while (!cursor.isAfterLast()){
           CongNhan congNhan = new CongNhan();
           congNhan.setNgayChamCong(cursor.getString(0));
           congNhan.setSoSanPham(cursor.getString(1));
           congNhan.setLoaiCongNhan(cursor.getString(2));
           congNhan.setLoaiSanPham(cursor.getString(3));
           data.add(congNhan);
           cursor.moveToNext();
       }

cursor.close();
        return  data;
    }
}
