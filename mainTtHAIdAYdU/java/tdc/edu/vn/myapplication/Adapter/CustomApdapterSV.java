package tdc.edu.vn.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;

import tdc.edu.vn.myapplication.GiaoDien.ChiTietActivity;
import tdc.edu.vn.myapplication.GiaoDien.MainActivity;
import tdc.edu.vn.myapplication.Model.CongNhan;
import tdc.edu.vn.myapplication.R;

public class CustomApdapterSV extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<CongNhan> data;
    ArrayList<CongNhan> data_DS;
    private Vector<CongNhan> list;

    public CustomApdapterSV(Context context, int resource, ArrayList<CongNhan> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.data_DS = new ArrayList<CongNhan>();
        this.data_DS.addAll(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        ImageView imgHinh;
        ImageView imgDetail;
        TextView tvHoTen;
        TextView tvPhanXuong;
        TextView tvMa;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.imgHinh = view.findViewById(R.id.imgHinh);
            holder.imgDetail = view.findViewById(R.id.imgDetail);
            holder.tvMa = view.findViewById(R.id.tvMaCN);
            holder.tvHoTen = view.findViewById(R.id.tvHoTen);
            holder.tvPhanXuong = view.findViewById(R.id.tvPhanXuong);
            view.setTag(holder);
        } else
            holder = (Holder) view.getTag();

        final CongNhan congNhan = data.get(position);
        holder.tvMa.setText(congNhan.getMaCN());
        holder.tvHoTen.setText(congNhan.getTenCN());
        holder.tvPhanXuong.setText(congNhan.getPhanXuong());
        holder.imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent((Activity) context, ChiTietActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma", congNhan.getMaCN());
                intent.putExtras(bundle);
                ((Activity) context).startActivity(intent);
            }
        });

        if(congNhan.getPhanXuong().equalsIgnoreCase(MainActivity.PHANXUONG1))
        {
            holder.imgHinh.setBackground(context.getResources().getDrawable(R.mipmap.xuong_1));
        }
        else if (congNhan.getPhanXuong().equalsIgnoreCase(MainActivity.PHANXUONG2))
        {
            holder.imgHinh.setBackground(context.getResources().getDrawable(R.mipmap.xuong_2));
        }
        else if (congNhan.getPhanXuong().equalsIgnoreCase(MainActivity.PHANXUONG3))
        {
            holder.imgHinh.setBackground(context.getResources().getDrawable(R.mipmap.xuong_3));
        }
        else
        {
            holder.imgHinh.setBackground(context.getResources().getDrawable(R.mipmap.xuong_4));
        }
        return view;
    }

    //filter
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        data.clear();
        if (charText.length() == 0) {
            data.addAll(data_DS);
        } else {
            for (CongNhan model : data_DS) {
                if (model.getTenCN().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    data.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
