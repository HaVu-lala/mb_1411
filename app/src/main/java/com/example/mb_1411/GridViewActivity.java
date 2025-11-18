package com.example.mb_1411;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<MonHoc> arrayList;
    private MonHocAdapter adapter;
    private EditText editText1;
    private Button btnNhap;
    private Button btnCapNhat;
    private int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        // Ánh xạ view và khởi tạo dữ liệu
        AnhXa();

        // Tạo Adapter
        adapter = new MonHocAdapter(this, R.layout.row_monhoc, arrayList);
        gridView.setAdapter(adapter);

        // Single item click: show position and load into editText for update
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(GridViewActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                editText1.setText(arrayList.get(position).getName());
                vitri = position;
            }
        });

        // Long click: delete item
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(GridViewActivity.this, "Đã xóa " + arrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(GridViewActivity.this, "Enter a value", Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(GridViewActivity.this, "Enter a value", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(GridViewActivity.this, "Please select an item to update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        gridView = (GridView) findViewById(R.id.gridview);
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
