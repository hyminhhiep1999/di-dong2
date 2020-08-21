package tdc.edu.vn.congnhanvs1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class list_CongNhan extends AppCompatActivity {
    ListView lvdsanhsach;
    ArrayList<CongNhan> data_CN = new ArrayList<>();
    CustomAdapter adapter_cn;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_congnhan);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();

    }

    private void setEvent() {
        DBCongNhan dbCongNhan = new DBCongNhan(this);
        data_CN = dbCongNhan.getDuLieu();
        adapter_cn = new CustomAdapter(this, R.layout.list_item_congnhan, data_CN);
        lvdsanhsach.setAdapter(adapter_cn);
        registerForContextMenu(lvdsanhsach);
    }

    private void setControl() {
        lvdsanhsach = findViewById(R.id.lvDanhsachcongnhan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionsearch, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.actionsearch);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
//Thầy lol
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter_cn.filter("");
                    lvdsanhsach.clearTextFilter();
                } else {
                    adapter_cn.filter(s);
                }
                return true;
            }
        });
        return true;
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
