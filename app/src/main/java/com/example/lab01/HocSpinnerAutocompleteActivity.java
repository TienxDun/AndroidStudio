package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab01.modun.MonHoc;
import com.example.lab01.modun.SinhVien;

import java.util.ArrayList;
import java.util.Calendar;

public class HocSpinnerAutocompleteActivity extends AppCompatActivity {
    Spinner spinnerMonHoc;
    TextView txtMonHoc;
    ArrayList<String> arrMonHoc;
    ArrayAdapter<String> adapterMonHoc;
    ArrayList<MonHoc> arrMonHoc2;
    ArrayAdapter<MonHoc> adapterMonHoc2;
    EditText edtMaSV, edtTenSV, edtDate;
    Button btnSaveSV, btnToday;
    ListView lvDsSinhVien;
    MonHoc monHoc = null;
    ArrayAdapter<SinhVien> adapterSinhVien;
    ArrayList<SinhVien> arrSinhVien;
    String[] listTinhThanh;
    ArrayAdapter<String> adapterTinhThanh;
    AutoCompleteTextView  autoDiaChiSV;
    CalendarView myCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoc_spinner_autocomplete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        handleEvents();
    }
    private void handleEvents() {
        spinnerMonHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //                String value = adapterMonHoc.getItem(position);
            //                txtMonHoc.setText(value);

                monHoc = arrMonHoc2.get(position);
                txtMonHoc.setText(monHoc.getTenMonHoc());
                adapterSinhVien.clear();
                adapterSinhVien.addAll(monHoc.getDsSinhVien());
                adapterSinhVien.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Viet su kien cho nut SaveSV
        btnSaveSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(edtMaSV.getText().toString());
                sv.setTenSV(edtTenSV.getText().toString());
                sv.setDiaChi(autoDiaChiSV.getText().toString());
                arrSinhVien.add(sv); //add sinhvien vao arrSinhVien
                monHoc.getDsSinhVien().add(sv); //add sinhvien vao dsSinhVien cua monHoc
                adapterSinhVien.notifyDataSetChanged(); //cap nhat lai adapter
                clearText();
            }
        });
        //Viet su kien cho nut Today
        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance(); //Lay ra ngay thang nam gio phut giay cua he thong
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH); //Thang bat dau tu 0
                int year = calendar.get(Calendar.YEAR);
                edtDate.setText(String.valueOf(day) + "/" + String.valueOf(month + 1) + "/" +String.valueOf(year));
            }
        });
        //Viet su kien chon ngay trong calander
        myCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                edtDate.setText(String.valueOf(dayOfMonth) + "/" + String.valueOf(month + 1) + "/" +String.valueOf(year));

            }
        });
    }
    private void addControls() {
        txtMonHoc=findViewById(R.id.txtMonHoc);
        spinnerMonHoc=findViewById(R.id.spinnerMonHoc);
        lvDsSinhVien=findViewById(R.id.lvDsSinhVien);
        edtMaSV=findViewById(R.id.edtMaSV);
        edtTenSV=findViewById(R.id.edtTenSV);
        btnSaveSV=findViewById(R.id.btnSaveSV);
        autoDiaChiSV=findViewById(R.id.autoDiaChiSV);
        edtDate=findViewById(R.id.edtDate);
        btnToday=findViewById(R.id.btnToday);
        myCalendar=findViewById(R.id.myCalendar);


        //Dữ liệu môn học cho adapter
        arrMonHoc=new ArrayList<>();
        arrMonHoc.add("Android");
        arrMonHoc.add("Lập trình cơ bản");
        arrMonHoc.add("Tin học văn phòng");
        arrMonHoc.add("Phân tích phần mềm");
        arrMonHoc.add("Lập trình Web");
        arrMonHoc.add("Lập trình di động");

        //Adapter
        //        adapterMonHoc=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrMonHoc);
        //        adapterMonHoc.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        //        spinnerMonHoc.setAdapter(adapterMonHoc);
        arrMonHoc2 = new ArrayList<>(); //Khoi tao danh sach
        arrMonHoc2.add(new MonHoc("Android"));
        arrMonHoc2.add(new MonHoc("Lập trình cơ bản"));
        arrMonHoc2.add(new MonHoc("Tin học văn phòng"));
        arrMonHoc2.add(new MonHoc("Phân tích phần mềm"));
        arrMonHoc2.add(new MonHoc("Lập trình Web"));
        arrMonHoc2.add(new MonHoc("Lập trình di động"));
        //Khoi tao Adapter
        adapterMonHoc2 = new ArrayAdapter<>(HocSpinnerAutocompleteActivity.this, android.R.layout.simple_list_item_1, arrMonHoc2);
        spinnerMonHoc.setAdapter(adapterMonHoc2);

        //Xu ly du lieu cho ListView Sinh Vien
        //Khoi tao danh sach arrSinhVien, adapterSinhVien
        arrSinhVien = new ArrayList<>();
        adapterSinhVien = new ArrayAdapter<>(HocSpinnerAutocompleteActivity.this, android.R.layout.simple_list_item_1, arrSinhVien);
        lvDsSinhVien.setAdapter(adapterSinhVien);

        //Xu ly du lieu cho AutoCompleteTextView Tinh Thanh
        listTinhThanh = getResources().getStringArray(R.array.tinh_thanh);
        adapterTinhThanh = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listTinhThanh);
        autoDiaChiSV.setAdapter(adapterTinhThanh);

    }

    public void clearText(){
        edtMaSV.setText("");
        edtTenSV.setText("");
        autoDiaChiSV.setText("");
        edtMaSV.requestFocus();

    }
}