package tdc.edu.vn.myapplication.GiaoDien;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Vector;

import tdc.edu.vn.myapplication.Adapter.MyAdapter;
import tdc.edu.vn.myapplication.DataBase.DBCongNhan;
import tdc.edu.vn.myapplication.Model.CardViewModel;
import tdc.edu.vn.myapplication.Model.CongNhan;
import tdc.edu.vn.myapplication.R;

public class ChiTietActivity extends AppCompatActivity {
    EditText txtMaCN, txtHoTen, txtPhanXuong;
    ArrayList<CongNhan> data_SV = new ArrayList<>();
    //
    private Vector<CardViewModel> data = new Vector<CardViewModel>();
    RecyclerView recyclerView;
    private int position = 0;
        private boolean direction = true;
    //schedule time to run code by 3000millis
//    private void scrollByTime()
//    {
//        final Handler handler = new Handler();
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                if(direction)
//                {
//                    position ++;
//                    if(position>=data.size()) {
//                        position --;
//                        direction =false;
//                    }
//                }
//                else {
//                    position--;
//                    if(position <=0)
//                    {
//                        direction = true;
//                    }
//                }
//                recyclerView.smoothScrollToPosition(position);
//                handler.postDelayed(this,3000);
//            }
//        });
//    }
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        setConTrol();
        setEvent();
        data.add(new CardViewModel("banh mi 1",R.drawable.banhmi1));
        data.add(new CardViewModel("banh mi 2",R.drawable.banhmi2));
        data.add(new CardViewModel("banh mi 3",R.drawable.banhmi3));
        data.add(new CardViewModel("banh mi 4",R.drawable.banhmi4));
        recyclerView = findViewById(R.id.recyclerView);
        // bước 1 : thằng recycler phải có thằng layoutmanager quản lý
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
////        cho các hình nằm chung 1 dòng
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //chia cột cho nó
//        GridLayoutManager layoutManager1 = new  GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
//        scrollByTime();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setEvent() {
        String ma= getIntent().getExtras().getString("ma");
        DBCongNhan dbCongNhan = new DBCongNhan(this);
        data_SV = dbCongNhan.LayDL(ma);
        txtMaCN.setText(data_SV.get(0).getMaCN());
        txtHoTen.setText(data_SV.get(0).getTenCN());
        txtPhanXuong.setText(data_SV.get(0).getPhanXuong());
    }

    private void setConTrol() {
        txtMaCN = findViewById(R.id.txtMaCN);
        txtHoTen = findViewById(R.id.txtHoTen);
        txtPhanXuong = findViewById(R.id.txtPhanXuong);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
