package com.example.lab01;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class Calculator_2_Activity extends AppCompatActivity {
    EditText edtNumber;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnr1, btnr2, btnClear, btnCong, btnTru, btnNhan, btnChia, btnBang, btnBack;

    String currentValue = "";
    String operator = "";

    String NextValue = "";

    double firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        handleEvents();
    }

    private void appendNumber(String value){
        currentValue += value;
        edtNumber.setText(currentValue);
    }

    private void setMyOperator(String operator){
        this.operator = operator;
        firstNumber = Double.parseDouble(currentValue);
        currentValue = "";
    }
    private void handleCalculate(){
        double secondNumber = Double.parseDouble(edtNumber.getText().toString());
        double ketqua = 0;
        switch (operator) {
            case "+":
                ketqua = firstNumber + secondNumber;
                break;
            case "-":
                ketqua = firstNumber - secondNumber;
                break;
            case "*":
                ketqua = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0)
                    ketqua = firstNumber / secondNumber;
                else {
                    ketqua = 0;
                    Toast.makeText(Calculator_2_Activity.this, "Không thể chia cho 0", Toast.LENGTH_LONG).show();
                }
                break;
        }
        // Kiểm tra kết quả và định dạng phù hợp
        String pattern;
        if (ketqua % 1 == 0) {
            // Nếu ketqua là số nguyên
            pattern = "#";
        } else {
            // Nếu ketqua có phần thập phân
            pattern = "#.######"; // Hiển thị tối đa 6 chữ số thập phân
        }
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String ketquaString = decimalFormat.format(ketqua);

        // Hiển thị kết quả
        edtNumber.setText(ketquaString);
        currentValue = String.valueOf(ketqua);
        NextValue = currentValue;
        operator = "";
    }

    private void lamTron(String digitNumber){
        int digit = digitNumber.length();
        double number = Double.parseDouble(edtNumber.getText().toString());
        if (digit == 2)
            number = (double )Math.round(number*10)/10;
        else if (digit == 3)
            number = (double )Math.round(number*100)/100;
        edtNumber.setText(String.valueOf(number));
    }

    private void handleEvents(){
        btn0.setOnClickListener(v -> appendNumber(btn0.getText().toString()));
        btn1.setOnClickListener(v -> appendNumber(btn1.getText().toString()));
        btn2.setOnClickListener(v -> appendNumber(btn2.getText().toString()));
        btn3.setOnClickListener(v -> appendNumber(btn3.getText().toString()));
        btn4.setOnClickListener(v -> appendNumber(btn4.getText().toString()));
        btn5.setOnClickListener(v -> appendNumber(btn5.getText().toString()));
        btn6.setOnClickListener(v -> appendNumber(btn6.getText().toString()));
        btn7.setOnClickListener(v -> appendNumber(btn7.getText().toString()));
        btn8.setOnClickListener(v -> appendNumber(btn8.getText().toString()));
        btn9.setOnClickListener(v -> appendNumber(btn9.getText().toString()));

        btnCong.setOnClickListener(v -> setMyOperator(btnCong.getText().toString()));
        btnTru.setOnClickListener(v -> setMyOperator(btnTru.getText().toString()));
        btnNhan.setOnClickListener(v -> setMyOperator(btnNhan.getText().toString()));
        btnChia.setOnClickListener(v -> setMyOperator(btnChia.getText().toString()));

        btnBang.setOnClickListener(v -> handleCalculate());
        btnr1.setOnClickListener(v -> lamTron(btnr1.getText().toString()));
        btnr2.setOnClickListener(v -> lamTron(btnr2.getText().toString()));
        btnClear.setOnClickListener(v -> {
            currentValue = "";
            operator = "";
            edtNumber.setText("");
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Calculator_2_Activity.this);
                dialog.setContentView(R.layout.customdialog1);
                ImageView imgNo = dialog.findViewById(R.id.imgNo);
                ImageView imgYes = dialog.findViewById(R.id.imgYes);

                // Cài đặt sự kiện cho nút No
                imgNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                // Cài đặt sự kiện cho nút Yes
                imgYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();  // Thoát Activity hiện tại
                    }
                });
                dialog.create();
                dialog.show();
            }
        });


    }
    private void addControl(){
        edtNumber = findViewById(R.id.edtNumber);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnr1 = findViewById(R.id.btnr1);
        btnr2 = findViewById(R.id.btnr2);
        btnClear = findViewById(R.id.btnClear);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnBang = findViewById(R.id.btnBang);
        btnBack = findViewById(R.id.btnBack);

    }
}
