package com.example.mb_1411;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnimationActivity extends AppCompatActivity {

    private Button btnAddItem;
    private RecyclerView rvItems;
    private CustomAnimationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        btnAddItem = findViewById(R.id.btn_add_item);
        rvItems = findViewById(R.id.rv_items);

        // Create initial data
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add("Item " + (i + 1));
        }

        // Setup RecyclerView
        adapter = new CustomAnimationAdapter(data);
        rvItems.setAdapter(adapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        // Use DefaultItemAnimator for built-in animations
        rvItems.setItemAnimator(new DefaultItemAnimator());

        // Set click listener for the button
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem("New Item");
                rvItems.scrollToPosition(adapter.getItemCount() - 1);
            }
        });
    }
}
