package com.example.lab01.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab01.R;
import com.example.lab01.model.SanPham;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    public SanPhamAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();//đọc item_layout;
        View viewSP=layoutInflater.inflate(R.layout.items,null);
        //tham chieu id co trong item_sp
        ImageView imgHinh=viewSP.findViewById(R.id.imgHinh);
        TextView txtTensp=viewSP.findViewById(R.id.txtTenSP);
        TextView txtMotasp=viewSP.findViewById(R.id.txtMotaSP);
        TextView txtGia=viewSP.findViewById(R.id.txtGiaSP);
        //lay ra sanpham tuong theo vi tri trong position cua listview
        SanPham sanPham=getItem(position);
        //set cac gia tri tuong ung vao thuoc tinh cua sanpham
        imgHinh.setImageResource(sanPham.getHinh());
        txtTensp.setText(sanPham.getTenSP());
        txtMotasp.setText(sanPham.getMoTa());
        txtGia.setText(sanPham.getGiaSP()+"");
        return viewSP;

    }
}
