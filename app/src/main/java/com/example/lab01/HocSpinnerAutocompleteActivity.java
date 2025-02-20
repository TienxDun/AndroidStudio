package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class HocSpinnerAutocompleteActivity extends AppCompatActivity {
    Spinner spinnerMonHoc;
    TextView txtMonHoc;
    ArrayList<String> arrMonHoc;
    ArrayAdapter<String> adapterMonHoc;
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
                String value = adapterMonHoc.getItem(position);
                txtMonHoc.setText(value);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void addControls() {
        txtMonHoc=findViewById(R.id.txtMonHoc);
        spinnerMonHoc=findViewById(R.id.spinnerMonHoc);
        //Dữ liệu môn học cho adapter
        arrMonHoc=new ArrayList<>();
        arrMonHoc.add("Android");
        arrMonHoc.add("Lập trình cơ bản");
        arrMonHoc.add("Tin học văn phòng");
        arrMonHoc.add("Phân tích phần mềm");
        arrMonHoc.add("Lập trình Web");
        arrMonHoc.add("Lập trình di động");

        //Adapter
        adapterMonHoc=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrMonHoc);
        spinnerMonHoc.setAdapter(adapterMonHoc);
    }


}