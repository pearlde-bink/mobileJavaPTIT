package com.example.ptitapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ptitapp1.model.Cat;
import com.example.ptitapp1.model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    CatAdapter adapter;
    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.rview);
        img = findViewById(R.id.img);
        txt = findViewById(R.id.txt1);
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(R.drawable.cat1, "Cat 1"));
        list.add(new Cat(R.drawable.cat2, "Cat 2"));
        list.add(new Cat(R.drawable.cat3, "Cat 3"));
        list.add(new Cat(R.drawable.cat4, "Cat 4"));
        list.add(new Cat(R.drawable.cat5, "Cat 5"));
        list.add(new Cat(R.drawable.cat6, "Cat 6"));

        adapter = new CatAdapter(this, list);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setOnCatItemListener(new CatAdapter.OnCatItemListener() {
            @Override
            public void onItemClick(View v, int position) {
                Cat c = list.get(position);
                img.setImageResource(c.getImage());
                txt.setText(c.getName());
            }
        });
    }
}