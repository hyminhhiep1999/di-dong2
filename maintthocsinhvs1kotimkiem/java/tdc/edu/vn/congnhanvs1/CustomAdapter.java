package tdc.edu.vn.congnhanvs1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<CongNhan> data;
    ArrayList<CongNhan>data_danhsach;
    public CustomAdapter(@NonNull Context context, int resource,ArrayList<CongNhan>data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_danhsach = new ArrayList<CongNhan>();
        this.data_danhsach.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
         convertView= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        ImageView imgLoai = convertView.findViewById(R.id.imgpicter_congnhan);
        //
        TextView tvNgayChamCong = convertView.findViewById(R.id.tvNgayChamCong);
        TextView tvSoSanPham = convertView.findViewById(R.id.tvSoSanPham);
        TextView tvCongNhan = convertView.findViewById(R.id.tvCongNhan);
        TextView tvSanPham = convertView.findViewById(R.id.tvSanPham);
        //
        CongNhan congNhan = data.get(position);
        //
        if(congNhan.getNgayChamCong().equals("San Pham Dau Khi"))
        {
            imgLoai.setImageResource(R.drawable.dautho);
        }
        else if (congNhan.getSoSanPham().equals("San Pham Chat Tay Rua"))
        {
            imgLoai.setImageResource(R.drawable.tayrua);
        }
        if(congNhan.getLoaiCongNhan().equals("San Pham Det May"))
        {
            imgLoai.setImageResource(R.drawable.maymac);
        }
        tvNgayChamCong.setText(congNhan.getNgayChamCong());
        tvSoSanPham.setText(congNhan.getSoSanPham());
        tvCongNhan.setText(congNhan.getLoaiCongNhan());
        tvSanPham.setText(congNhan.getLoaiSanPham());

        return convertView;
    }
    public void filter(String chartText)
    {
        chartText = chartText.toLowerCase(Locale.getDefault());
        data.clear();
        if(chartText.length() == 0){
            data.addAll(data_danhsach);
        }
        else{
            for (CongNhan model : data)
            {
                if(model.getNgayChamCong().toLowerCase(Locale.getDefault()).contains(chartText))
                {

                    data.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
