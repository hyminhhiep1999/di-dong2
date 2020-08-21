package tdc.edu.vn.denamngoaidd1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DB_Persion  {
    DBhelper dBhelper;

    public DB_Persion(Context context) {
        this.dBhelper = new DBhelper(context);
    }
    public void Them(Persion persion)
    {
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //hovaten text,tuoi text,gioitinh text,arrSothich text
        values.put("hovaten",persion.getHovaten());
        values.put("tuoi",persion.getTuoi());
        values.put("gioitinh",persion.getGioitinh());
        values.put("arrSothich",persion.getArrSothich());
        database.insert("Persion",null,values);
    }
    public void Xoa(Persion persion)
    {
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        String sql = "Delete from Persion where hovaten ='" + persion.getHovaten() + "'";
        database.execSQL(sql);

    }
    public void Sua(Persion persion){
        SQLiteDatabase database = dBhelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("hovaten",persion.getHovaten());
        values.put("tuoi",persion.getTuoi());
        values.put("gioitinh",persion.getGioitinh());
        values.put("arrSothich",persion.getArrSothich());
        database.update("Persion" , values,"hovaten = '" + persion.getHovaten() +"'",null);
    }
    public ArrayList<Persion> get_persion() {
        ArrayList<Persion> persions = new ArrayList<>();
        String sql = "SELECT * FROM Persion";
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);

        cursor.moveToFirst();


        while (!cursor.isAfterLast()) {
            Persion persion = new Persion();
            persion.setHovaten(cursor.getString(0));
            persion.setTuoi(cursor.getString(1));
            persion.setGioitinh(cursor.getString(2));
            persion.setArrSothich(cursor.getString(3));
            persions.add(persion);
            cursor.moveToNext();
        }

        cursor.close();
        return persions;
    }
}
