package com.example.lab01;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class MyCustomDialog1 extends Dialog {
    // Khai báo các view có trong MyCustomDialog1

    ImageView imgYes, imgNo;
    Activity context;
    public MyCustomDialog1(Activity context) {
        super(context);
        this.context = (Activity) context; // Correctly assign context
        //Truyền layout dialog đã thiết kế
        setContentView(R.layout.customdialog2);
        addControls();
        addhandleEvents();
        setCanceledOnTouchOutside(false);
    }

    private void addhandleEvents() {
        //Nút Yes
        imgYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (context != null) {
                    context.finish(); // Now context is correctly assigned
                }
            }
        });

        //Nút No
        imgNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    private void addControls() {
        imgYes = findViewById(R.id.imgYes);
        imgNo = findViewById(R.id.imgNo);
    }
}
