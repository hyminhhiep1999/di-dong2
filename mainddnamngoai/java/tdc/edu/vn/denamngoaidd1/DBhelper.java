package tdc.edu.vn.denamngoaidd1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBhelper extends SQLiteOpenHelper {
    public DBhelper( Context context) {
        super(context,"QL_Persion",null,1);
    }
//    String hovaten,tuoi,gioitinh;
//    String[] arrSothich;
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Persion(hovaten text,tuoi text,gioitinh text,arrSothich text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
