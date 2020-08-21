package tdc.edu.vn.denamngoaidd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class add_activity extends AppCompatActivity {
    EditText edthovaten, edtTuoi;
    RadioButton radNam, rdoNu;
    CheckBox ckban, ckbchoi;
    Button btnAdd, btnBack,btnSua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);
        setControl();
        setEvent();
    }

    private void setEvent() {
//        if(getIntent().getExtras().getInt("so") >= 0)
//        {
//            ArrayList<Persion> persions = new DB_Persion(getApplicationContext()).get_persion();
//            Persion persion = persions.get(getIntent().getExtras().getInt("so"));
//            edthovaten.setText(persion.getHovaten());
//            edtTuoi.setText(persion.getTuoi());
//            if(persion.getGioitinh().equals("nam"))
//            {
//                radNam.setChecked(true);
//            }
//            else {
//                radNam.setChecked(true);
//            }
//            if()
//        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persion persion = getDulieu();
                /**
                 DB_Persion db_persion = new DB_persion(getApplicationContext());
                 db_persion.Them(persion)
                 */
                new DB_Persion(getApplicationContext()).Them(persion);
                Toast.makeText(getApplicationContext(),"Them thanh cong ",Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });

    }

    private Persion getDulieu() {
        Persion persion = new Persion();

        persion.setHovaten(edthovaten.getText().toString());
        persion.setTuoi(edtTuoi.getText().toString());
        if (radNam.isChecked()) {
            persion.setGioitinh("nam");
        } else {
            persion.setGioitinh("nu");
        }
        if (ckban.isChecked() && ckbchoi.isChecked()) {
            persion.setArrSothich(ckban.getText().toString() + "," + ckbchoi.getText().toString());
        } else if (ckban.isChecked()) {
            persion.setArrSothich(ckban.getText().toString());
        } else if (ckbchoi.isChecked()) {
            persion.setArrSothich(ckbchoi.getText().toString());
        } else {
            persion.setArrSothich("");
        }

        return persion;
    }

    private void setControl() {
        edthovaten = findViewById(R.id.edtTen);
        edtTuoi = findViewById(R.id.edtTuoi);
        radNam = findViewById(R.id.rdbNam);
        rdoNu = findViewById(R.id.rdbNu);
        ckban = findViewById(R.id.cban);
        ckbchoi = findViewById(R.id.cbchoi);
        btnAdd = findViewById(R.id.btnThem);
        btnBack = findViewById(R.id.btnBack);
        btnSua = findViewById(R.id.btnFix);
    }
}
