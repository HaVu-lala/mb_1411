package com.example.mb_1411;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MultipleViewTypeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view_type);

        recyclerView = findViewById(R.id.recycler_view_multiple);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a mixed data list
        List<Object> data = new ArrayList<>();
        data.add("This is the first text item.");
        data.add(new UserModel("Nguyễn Văn A", "Hà Nội"));
        data.add(R.drawable.java1); // Assuming you have this drawable
        data.add("Another text line here.");
        data.add(new UserModel("Trần Thị B", "TP. Hồ Chí Minh"));
        data.add("A third line of text.");
        data.add(R.drawable.c); // Assuming you have this drawable
        data.add(new UserModel("Lê Văn C", "Đà Nẵng"));

        // Set adapter
        CustomAdapter adapter = new CustomAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}
