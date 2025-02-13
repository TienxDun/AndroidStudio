package com.example.lab01;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThongTin_3_Activity extends AppCompatActivity {

    ImageButton imgBtnBack;
     EditText edtCMND, edtHoTen, edtDiaChi;
     CheckBox chkBook, chkTravel, chkMusic;
     RadioGroup radioGroupGioiTinh;
     Button btnCapNhat,btnLamLai;
     TextView txtThongTinChiTiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thong_tin3);

        addControls();
        handleEvents();
        // Giữ nguyên phần cài đặt EdgeToEdge và Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void handleEvents() {
        // Xử lý sự kiện
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienThiThongTin();
            }
        });
        btnLamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtCMND.setText("");
                edtHoTen.setText("");
                edtDiaChi.setText("");
                radioGroupGioiTinh.clearCheck();
                chkBook.setChecked(false);
                chkTravel.setChecked(false);
                chkMusic.setChecked(false);
            }
        });
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo và khởi tạo hộp thoại khai báo
                AlertDialog.Builder builder = new AlertDialog.Builder(ThongTin_3_Activity.this);
                // Truyền các tham số cơ bản cho alert
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát khỏi ứng dụng?");
                builder.setIcon(R.drawable.ic_close1);
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.create();
                builder.show();
            }
        });

    }
    private void addControls() {
        // Ánh xạ các view theo ID mới
        imgBtnBack = findViewById(R.id.imgBtnBack);
        edtCMND = findViewById(R.id.edtCMND);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        chkBook = findViewById(R.id.chkBook);
        chkTravel = findViewById(R.id.chkTravel);
        chkMusic = findViewById(R.id.chkMusic);
        radioGroupGioiTinh = findViewById(R.id.radioGroupGioiTinh);
        btnCapNhat = findViewById(R.id.btnCapNhat);
        txtThongTinChiTiet = findViewById(R.id.txtThongTinChiTiet);
        btnLamLai =findViewById(R.id.btnLamLai);

    }
    private void hienThiThongTin() {
        String cmnd = edtCMND.getText().toString().trim();
        String hoTen = edtHoTen.getText().toString().trim();
        String diaChi = edtDiaChi.getText().toString().trim();

        // Kiểm tra thông tin bắt buộc
        if (cmnd.isEmpty() || hoTen.isEmpty() || diaChi.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ CMND, Họ tên và Địa chỉ.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy giới tính
        int selectedId = radioGroupGioiTinh.getCheckedRadioButtonId();
        String gioiTinh = "";
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            gioiTinh = radioButton.getText().toString();
        } else {
            gioiTinh = "Chưa xác định";
        }

        // Lấy sở thích
        StringBuilder soThich = new StringBuilder();
        if (chkBook.isChecked())
            soThich.append("Book, ");
        if (chkTravel.isChecked())
            soThich.append("Travel, ");
        if (chkMusic.isChecked())
            soThich.append("Music, ");

        // Xóa dấu phẩy cuối chuỗi
        if (soThich.length() > 0)
            soThich.setLength(soThich.length() - 2);
        else
            soThich.append("Không có");

        // Chuẩn bị chuỗi hiển thị
        String thongTin = "CMND: " + cmnd + "\n"
                + "Họ tên: " + hoTen + "\n"
                + "Địa chỉ: " + diaChi + "\n"
                + "Sở thích: " + soThich.toString()+ "\n"
                + "Giới tính: " + gioiTinh;

        // Hiển thị thông tin
        txtThongTinChiTiet.setText(thongTin);
    }
}