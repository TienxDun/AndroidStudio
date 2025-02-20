package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab01.adapter.SanPhamAdapter;
import com.example.lab01.model.SanPham;

public class ListView_SanPhamActivity extends AppCompatActivity {
    private ListView lvSanPham;
    private SanPhamAdapter sanPhamAadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_san_pham);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        loadData();
        addEvents();
    }

    private void addEvents() {
        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = sanPhamAadapter.getItem(position);
                Intent intent = new Intent(ListView_SanPhamActivity.this, Details_SanPhamActivity.class);
                intent.putExtra("sanpham", sp);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        sanPhamAadapter.add(new SanPham(R.drawable.pic7,"Hình 1", "Mô tả 1", 100000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic8,"Hình 2", "Mô tả 2", 200000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic9,"Hình 3", "Mô tả 3", 300000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic10,"Hình 4", "Mô tả 4", 400000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic11,"Hình 5", "Mô tả 5", 500000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic12,"Hình 6", "Mô tả 6", 600000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic13,"Hình 7", "Mô tả 7", 700000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic14,"Hình 8", "Mô tả 8", 800000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic15,"Hình 9", "Mô tả 9", 900000));
        sanPhamAadapter.add(new SanPham(R.drawable.pic16,"Hình 10", "Mô tả 10", 1000000));
    }

    private void addControls() {
        lvSanPham = findViewById(R.id.lvSanPham);
        sanPhamAadapter = new SanPhamAdapter(ListView_SanPhamActivity.this, R.layout.items);
        lvSanPham.setAdapter(sanPhamAadapter);
    }
}