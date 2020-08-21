package tdc.edu.vn.denamngoaidd1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    Context context;
    ArrayList<Persion> persions;

    int layout_int;

    public Custom_Adapter(Context context, ArrayList<Persion> persions, int layout_int) {
        this.context = context;
        this.persions = persions;
        this.layout_int = layout_int;
    }

    @Override
    public int getCount() {
        return persions.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(layout_int, viewGroup, false);

        ImageView img_ps = view.findViewById(R.id.img_persion);
        TextView tv_hoten = view.findViewById(R.id.tv_hoten);
        TextView tv_tuoi = view.findViewById(R.id.tv_tuoi);
        TextView tv_gioitinh = view.findViewById(R.id.tv_gioitinh);
        TextView tv_sothich = view.findViewById(R.id.tv_sothich);
        Button btn_Sua = view.findViewById(R.id.btnSua);


        Persion persion = persions.get(i);
        tv_hoten.setText(persion.getHovaten());
        tv_tuoi.setText(persion.getTuoi());
        tv_gioitinh.setText(persion.getGioitinh());
        tv_sothich.setText(persion.getArrSothich());
//        btn_Sua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(),add_activity.class);
////   truyen gia tri thong qua chu
//                intent.putExtra("so",i);
//               view.getContext().startActivity(intent);
//            }
//        });
        return view;
    }
}
