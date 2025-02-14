package com.example.lab01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab01.model.Contact;

public class ListView_ContactActivity extends AppCompatActivity {
    Button btnSaveContact, btnDeleteContact, btnUpdateContact;
    EditText edtMaContact, edtTenContact, edtSDTContact;
    ListView lvContact;
    ArrayAdapter<Contact> adapterContact;

    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControls();
        addEvents();
    }

    private void addEvents() {
        //Khi ấn nút Save thì đối tượng Contact được tạo ra trong List View
        btnSaveContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo đối tượng Contact
                Contact contact = new Contact();
                // Lấy dữ liệu từ EditText gán vào đối tượng Contact
                contact.setMaContact(edtMaContact.getText().toString());
                contact.setTenContact(edtTenContact.getText().toString());
                contact.setSDTContact(edtSDTContact.getText().toString());
                //Add contact vào adapter
                adapterContact.add(contact);
                edtMaContact.requestFocus();
            }
        });
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
                Contact contact = adapterContact.getItem(position); //Lấy dữ liệu tại dòng item click
                //Set dữ liệu vào EditText bằng hàm get dữ liệu từ Contact
                edtMaContact.setText(contact.getMaContact());
                edtTenContact.setText(contact.getTenContact());
                edtSDTContact.setText(contact.getSDTContact());
                edtMaContact.requestFocus();
            }
        });
        lvContact.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Xóa contact khi click lâu vào đối tượng trong ListView
                adapterContact.remove(adapterContact.getItem(position));
                return false;
            }
        });
        btnUpdateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Để update item thì phải lấy vị trí item cần update
                Contact contact = adapterContact.getItem(index); //index là postion
                //Thay đổi giá trị cho các thuộc tính của Contact bằng cách set
                contact.setMaContact(edtMaContact.getText().toString());
                contact.setTenContact(edtTenContact.getText().toString());
                contact.setSDTContact(edtSDTContact.getText().toString());
                //Chấp nhận sự thay đổi dữ liệu
                adapterContact.notifyDataSetChanged();
                edtMaContact.requestFocus();
            }
        });
        btnDeleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = adapterContact.getItem(index);
                edtMaContact.setText(contact.getMaContact());
                edtTenContact.setText(contact.getTenContact());
                edtSDTContact.setText(contact.getSDTContact());
                //Xóa item trong ListView
                adapterContact.remove(contact);
                //Làm rỗng các EditText
                edtMaContact.setText("");
                edtTenContact.setText("");
                edtSDTContact.setText("");
                edtMaContact.requestFocus();
            }
        });
    }

    private void addControls() {
        btnSaveContact = findViewById(R.id.btnSaveContact);
        btnDeleteContact = findViewById(R.id.btnDeleteContact);
        btnUpdateContact = findViewById(R.id.btnUpdateContact);
        edtMaContact = findViewById(R.id.edtMaContact);
        edtTenContact = findViewById(R.id.edtTenContact);
        edtSDTContact = findViewById(R.id.edtSDTContact);
        lvContact = findViewById(R.id.lvContact);
        // Tạo arrayAdapter kết nối dữ liệu Contact với ListView
        adapterContact = new ArrayAdapter<>(ListView_ContactActivity.this, android.R.layout.simple_list_item_1);
        lvContact.setAdapter(adapterContact);

    }
}