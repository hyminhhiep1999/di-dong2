package tdc.edu.vn.denamngoaidd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_data_persion;
    Button btnADD, btnExit;
    ArrayList<Persion>persions=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void hienthiDL(){
        persions = new DB_Persion(getApplicationContext()).get_persion();
        Custom_Adapter custom_adapter = new Custom_Adapter(getApplicationContext(),persions,R.layout.item_persion);
        lv_data_persion.setAdapter(custom_adapter);
    }
    private void setEvent() {
        hienthiDL();
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),add_activity.class);
                startActivity(intent);

            }
        });
        lv_data_persion.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Persion persion = persions.get(i);
                new DB_Persion(getApplicationContext()).Xoa(persion);
                Toast.makeText(getApplicationContext(),"Xoa thanh cong", Toast.LENGTH_LONG).show();
                hienthiDL();
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        hienthiDL();
        super.onResume();
    }

    private void setControl() {
        btnADD = findViewById(R.id.btnADD);
        btnExit = findViewById(R.id.btnExit);
        lv_data_persion = findViewById(R.id.lv_persion);
    }
}
