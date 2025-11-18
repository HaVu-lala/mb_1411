package com.example.mb_1411;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<MonHoc> arrayList;
    private MonHocAdapter adapter;
    private EditText editText1;
    private Button btnNhap;
    private Button btnCapNhat;
    private int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ view và khởi tạo dữ liệu
        AnhXa();

        // Tạo Adapter
        adapter = new MonHocAdapter(MainActivity.this, R.layout.row_monhoc, arrayList);
        //truyền dữ liệu từ adapter ra listview
        listView.setAdapter(adapter);

        // Single item click: show position and load into editText for update
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                editText1.setText(arrayList.get(position).getName());
                vitri = position;
            }
        });

        // Long click: delete item
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "Đã xóa " + arrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        // Add new item
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString().trim();
                if (!name.isEmpty()) {
                    // Thêm một môn học mới với ảnh mặc định
                    arrayList.add(new MonHoc(name, "Mô tả cho " + name, R.drawable.ic_launcher_foreground));
                    adapter.notifyDataSetChanged();
                    editText1.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Enter a value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Update selected item
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vitri >= 0 && vitri < arrayList.size()) {
                    String newName = editText1.getText().toString().trim();
                    if (!newName.isEmpty()) {
                        MonHoc monHoc = arrayList.get(vitri);
                        monHoc.setName(newName);
                        adapter.notifyDataSetChanged();
                        vitri = -1;
                        editText1.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Enter a value", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please select an item to update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        listView = (ListView) findViewById(R.id.listview1);
        editText1 = (EditText) findViewById(R.id.editText1);
        btnNhap = (Button) findViewById(R.id.btnNhap);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        //Thêm dữ liệu vào List
        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java","Java 1",R.drawable.java1));
        arrayList.add(new MonHoc("C#","C# 1",R.drawable.c));
        arrayList.add(new MonHoc("PHP","PHP 1",R.drawable.php));
        arrayList.add(new MonHoc("Kotlin","Kotlin 1",R.drawable.kotlin));
        arrayList.add(new MonHoc("Dart","Dart 1",R.drawable.dart));
    }
}
