package tdc.edu.vn.congnhanvs1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(Context context){
        super(context,"QLCongNhan",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table CongNhan (ngayChamCong text, soSanPham text,loaiCongNhan text,loaiSanPham text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
