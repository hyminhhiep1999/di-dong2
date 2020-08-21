package tdc.edu.vn.congnhanvs1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtNgayChamCong, edtSoLuongSP;
    Spinner spnCongNhan, spnSanPham;
    Button btnThem, btnXoa, btnSua, btnClear;
    ListView lvDanhSach;
    ArrayList<String> data_CongNhan = new ArrayList<>();
    ArrayList<String> data_SanPham = new ArrayList<>();
    ArrayList<CongNhan> data = new ArrayList<>();
    ArrayAdapter adapter_congnhan;
    ArrayAdapter adapter_sanpham;
    CustomAdapter adapter_ccnn;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
public void Hienthi(){
        data = new DBCongNhan(getApplicationContext()).getDuLieu();
        adapter_ccnn = new CustomAdapter(this, R.layout.list_item_congnhan, data);
        lvDanhSach.setAdapter(adapter_ccnn);
}
    private void setEvent() {
        KhoiTao();
        adapter_congnhan = new ArrayAdapter(this, android.R.layout.simple_spinner_item, data_CongNhan);
        spnCongNhan.setAdapter(adapter_congnhan);
        adapter_sanpham = new ArrayAdapter(this, android.R.layout.simple_spinner_item, data_SanPham);
        spnSanPham.setAdapter(adapter_sanpham);
        Hienthi();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CongNhan congNhan = getCongNhan();
                data.add(congNhan);
                adapter_ccnn.notifyDataSetChanged();
                DBCongNhan dbmonhoc = new DBCongNhan(getApplicationContext());
                CongNhan congnhan = getCongNhan();
                dbmonhoc.Them(congnhan);
                Hienthi();
            }
        });

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CongNhan congNhan = data.get(position);
                edtNgayChamCong.setText(congNhan.getNgayChamCong());
                edtSoLuongSP.setText(congNhan.getSoSanPham());
                spnCongNhan.setSelection(data.indexOf(congNhan.getLoaiCongNhan()));
                index = position;
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(index);
                adapter_congnhan.notifyDataSetChanged();
                adapter_sanpham.notifyDataSetChanged();
                adapter_ccnn.notifyDataSetChanged();
                DBCongNhan dbmonhoc = new DBCongNhan(getApplicationContext());
                CongNhan congnhan = getCongNhan();
                dbmonhoc.Xoa(congnhan);
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CongNhan sinhVien = data.get(index);
                sinhVien.setNgayChamCong(edtNgayChamCong.getText().toString());
                sinhVien.setSoSanPham(edtSoLuongSP.getText().toString());
                sinhVien.setLoaiCongNhan(spnCongNhan.getSelectedItem().toString());
                sinhVien.setLoaiSanPham(spnSanPham.getSelectedItem().toString());
                adapter_ccnn.notifyDataSetChanged();


                DBCongNhan dbmonhoc = new DBCongNhan(getApplicationContext());
                CongNhan congnhan = getCongNhan();
                dbmonhoc.Sua(congnhan);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtNgayChamCong.setText("");
                edtSoLuongSP.setText("");
                spnCongNhan.setSelection(0);
                spnSanPham.setSelection(0);

            }
        });


    }

    private void setControl() {
        edtNgayChamCong = findViewById(R.id.txtNhapNgayChamCong);
        edtSoLuongSP = findViewById(R.id.txtNhapSoLuongSP);
        spnCongNhan = findViewById(R.id.spnCongNhan);
        spnSanPham = findViewById(R.id.spnsanpham);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnClear = findViewById(R.id.btnClear);
        lvDanhSach = findViewById(R.id.lvds);
    }

    private CongNhan getCongNhan() {
        CongNhan congNhan = new CongNhan();
        congNhan.setNgayChamCong(edtNgayChamCong.getText().toString());
        congNhan.setSoSanPham(edtSoLuongSP.getText().toString());
        congNhan.setLoaiCongNhan(spnCongNhan.getSelectedItem().toString());
        congNhan.setLoaiSanPham(spnSanPham.getSelectedItem().toString());
        return congNhan;
    }

    private void KhoiTao() {
        data_CongNhan.add("Cong Nhan Dau Khi");
        data_CongNhan.add("Cong Nhan Hoa Hoc");
        data_CongNhan.add("Cong Nhan Xuong");
        //
        data_SanPham.add("San Pham Dau Khi");
        data_SanPham.add("San Pham Chat Tay Rua");
        data_SanPham.add("San Pham Det May");

        CongNhan congNhan = new CongNhan();
        congNhan.setNgayChamCong("12/12/2014");
        congNhan.setSoSanPham("1000");
        congNhan.setLoaiCongNhan("Cong Nhan Dau Khi");
        congNhan.setLoaiSanPham("San Pham Dau Khi");
        data.add(congNhan);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnLuu:
                Log.d("Test", "Luu ");
                break;
            case R.id.mnChuyen:
                Log.d("Test", "Chuyen ");
                Intent intent = new Intent(getApplicationContext(), list_CongNhan.class);
                startActivity(intent);
                break;
            case R.id.mnexit:
                Log.d("Test", "Thoat");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thong bao !!!");
                builder.setMessage("ban co muon thoat ?");
                builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.create().show();

                break;

//            case R.id.mnThoat:
//                Log.d("text", "Thoat");
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Thông báo!!!");
//                builder.setMessage("B?n có mu?n thoát không ?");
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();
//                break;
        }
        return true;
    }
}
