package com.example.sqlite_quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlite_quanlysinhvien.R;
import com.example.sqlite_quanlysinhvien.model.Sinhvien;

import java.util.List;

public class SinhvienAdapter extends BaseAdapter {
    private Context context;
    private List<Sinhvien> sinhvienList;

    public SinhvienAdapter(Context context, List<Sinhvien> sinhvienList) {
        this.context = context;
        this.sinhvienList = sinhvienList;
    }

    @Override
    public int getCount() {
        return sinhvienList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder= new ViewHolder();
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listview_item,null);
            viewHolder.txtmasv=convertView.findViewById(R.id.txt_masv);
            viewHolder.txthoten=convertView.findViewById(R.id.txt_hoten);
            viewHolder.txtsdt=convertView.findViewById(R.id.txt_sdt);
            viewHolder.txtemail=convertView.findViewById(R.id.txt_email);
            viewHolder.image=convertView.findViewById(R.id.imagegt);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder=(ViewHolder) convertView.getTag();

        }
        Sinhvien sv= sinhvienList.get(position);
        viewHolder.txtmasv.setText("Mã SV"  +sv.getMasv112());
        viewHolder.txthoten.setText("Họ tên"  +sv.getHoten112());
        viewHolder.txtsdt.setText("SĐT"  +sv.getDienthoai112());
        viewHolder.txtemail.setText("Email"  +sv.getEmail112());
        if(sv.getGioitinh112()==0) {
            viewHolder.image.setImageResource(R.drawable.girl);
        }
        else {
            viewHolder.image.setImageResource(R.drawable.man);
        }
        return convertView;
    }
    class ViewHolder
    {
       ImageView image;
       TextView txtmasv,txthoten,txtsdt,txtemail;
    }
}
