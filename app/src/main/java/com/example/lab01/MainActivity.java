package com.example.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Khai báo các ImageButton
    ImageButton imageButton4, imageButton5,imageButton6, imgLab03;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addControl();
        addEvents();
        // Giữ nguyên phần cài đặt EdgeToEdge và Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        // Thiết lập OnClickListener cho imageButton4
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Tạo Intent để mở Danhmuc_1_Activity
                Intent intent = new Intent(MainActivity.this, Danhmuc_1_Activity.class);
                startActivity(intent);
            }
        });

        // Thiết lập OnClickListener cho imageButton5
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Tạo Intent để mở Calculator_2_Activity
                Intent intent = new Intent(MainActivity.this, Calculator_2_Activity.class);
                startActivity(intent);
            }
        });

        // Thiết lập OnClickListener cho imageButton6
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Tạo Intent để mở ThongTin_3_Activity
                Intent intent = new Intent(MainActivity.this, ThongTin_3_Activity.class);
                startActivity(intent);
            }
        });

        // Thiết lập OnClickListener cho imgLab03
        imgLab03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Tạo Intent để mở Lab03
                Intent intent = new Intent(MainActivity.this, Lab03_AlertDialog_Activity.class);
                startActivity(intent);
            }
        });
    }

    public void addControl(){
        // Liên kết các ImageButton với các thành phần trong layout
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton6 = findViewById(R.id.imageButton6);
        imgLab03 = findViewById(R.id.imgLab03);
    }
}
