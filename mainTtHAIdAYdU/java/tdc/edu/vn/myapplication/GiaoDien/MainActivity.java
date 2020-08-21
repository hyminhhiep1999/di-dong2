package tdc.edu.vn.myapplication.GiaoDien;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import tdc.edu.vn.myapplication.Adapter.CustomApdapterSV;
import tdc.edu.vn.myapplication.DataBase.DBCongNhan;
import tdc.edu.vn.myapplication.Model.CongNhan;
import tdc.edu.vn.myapplication.R;

public class MainActivity extends AppCompatActivity {
    Button btnNgonNgu, btnThem,btnExit,btnXoa;
    EditText txtMaCN, txtHoTen, txtPhanXuong;
    ListView lvDanhSachCN;

    boolean ngonngu=true;
    public static String PHANXUONG1 = "1";
    public static String PHANXUONG2 = "2";
    public static String PHANXUONG3 = "3";
    public static String PHANXUONG4 = "4";
    CustomApdapterSV apdapter ;
    ArrayList<CongNhan> data_CN = new ArrayList<>();
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setConTrol();
        setEvent();
    }
    private void setEvent() {
        HienThiDL();
        btnNgonNgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ngonngu)
                    btnNgonNgu.setBackgroundResource(R.drawable.vietnam);
                else
                    btnNgonNgu.setBackgroundResource(R.drawable.anh);
                ngonngu =!ngonngu;
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ThemDL();
               HienThiDL();

            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XoaDL();
                HienThiDL();
            }

        });
        lvDanhSachCN.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;
                CongNhan congNhan = data_CN.get(i);
                txtMaCN.setText(congNhan.getMaCN());
                txtHoTen.setText(congNhan.getTenCN());
                txtPhanXuong.setText(congNhan.getPhanXuong());
            }
        });
    }

    private  void HienThiDL()
    {
        //list View
        DBCongNhan dbCongNhan = new DBCongNhan(this);
        data_CN = dbCongNhan.LayDL();
        apdapter = new CustomApdapterSV(this,R.layout.listview_item, data_CN);
        lvDanhSachCN.setAdapter(apdapter);
    }

    private  void ThemDL()
    {
        DBCongNhan dbCongNhan = new DBCongNhan(this);
        CongNhan congNhan = new CongNhan();
        congNhan.setMaCN(txtMaCN.getText().toString());
        congNhan.setTenCN(txtHoTen.getText().toString());
        congNhan.setPhanXuong(txtPhanXuong.getText().toString());
        dbCongNhan.Them(congNhan);
    }
    private  void XoaDL()
    {
        DBCongNhan dbCongNhan = new DBCongNhan(this);
        CongNhan congNhan = data_CN.get(index);
        dbCongNhan.Xoa(congNhan);
    }


    private void setConTrol() {
        btnNgonNgu = findViewById(R.id.btnNgonNgu);
        btnXoa = findViewById(R.id.btnXoa);
        btnThem = findViewById(R.id.btnThem);
        btnExit = findViewById(R.id.btnThoat);
        txtMaCN = findViewById(R.id.txtMaCN);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtPhanXuong = findViewById(R.id.txtPhanXuong);
        lvDanhSachCN = findViewById(R.id.lvDanhSach);
    }
}
