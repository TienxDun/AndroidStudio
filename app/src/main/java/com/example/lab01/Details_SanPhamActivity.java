package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab01.model.SanPham;

public class Details_SanPhamActivity extends AppCompatActivity {
    ImageView ivHinhCT;
    TextView txtTenspCT;
    TextView txtMotaspCT;
    TextView txtGiaspCT;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_san_pham);
        addControls();
    }

    private void addControls() {
        ivHinhCT=findViewById(R.id.ivHinhCT);
        txtTenspCT=findViewById(R.id.txtTenspCT);
        txtMotaspCT=findViewById(R.id.txtMotaspCT);
        txtGiaspCT=findViewById(R.id.txtGiaspCT);

        intent = getIntent();
        SanPham sp = (SanPham) intent.getSerializableExtra("sanpham");
        ivHinhCT.setImageResource(sp.getHinh());
        txtTenspCT.setText(sp.getTenSP());
        txtMotaspCT.setText(sp.getMoTa());
        txtGiaspCT.setText(sp.getGiaSP()+"");

    }
}