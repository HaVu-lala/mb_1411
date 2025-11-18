package com.example.mb_1411;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
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

        // Find views
        listView = findViewById(R.id.listview1);
        editText1 = findViewById(R.id.editText1);
        btnNhap = findViewById(R.id.btnNhap);
        btnCapNhat = findViewById(R.id.btnCapNhat);

        // Prepare data
        arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kotlin");
        arrayList.add("Dart");

        // Adapter
        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(adapter);

        // Single item click: show position and load into editText for update
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                editText1.setText(arrayList.get(position));
                vitri = position;
            }
        });

        // Long click: show message (keeps item)
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "Bạn đang nhấn giữ " + position + " - " + arrayList.get(position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        // Add new item
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString().trim();
                if (!name.isEmpty()) {
                    arrayList.add(name);
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
                String name = editText1.getText().toString().trim();
                if (vitri >= 0 && vitri < arrayList.size()) {
                    if (!name.isEmpty()) {
                        arrayList.set(vitri, name);
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

        // If you intended to delete an item, add a delete button and call:
        // if (vitri >= 0) { arrayList.remove(vitri); adapter.notifyDataSetChanged(); vitri = -1; }
    }
}
