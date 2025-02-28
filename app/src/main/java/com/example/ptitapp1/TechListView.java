package com.example.ptitapp1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ptitapp1.model.Technology;
import com.example.ptitapp1.model.TechnologyAdapter;

public class TechListView extends AppCompatActivity {
    private android.widget.ListView lv;
    TechnologyAdapter adapter;
    private Technology[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tech_list_view);
        lv = findViewById(R.id.lv);
        initData();
        adapter = new TechnologyAdapter(this, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i = 0; i < lv.getAdapter().getCount(); i++){
                    lv.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                }
                lv.getChildAt(position).setBackgroundColor(Color.GREEN);
                Technology t = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), t.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initData() {
        Integer[] imgs = {R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4};
        String[] names = {"Android", "IOS", "Ubuntu", "MacOS"};
        String[] subs = {"Sub Android", "Sub IOS", "Sub Ubuntu", "Sub MacOS"};
        String[] descs = {"Description Android", "Description IOS", "Description Ubuntu", "Description MacOS"};

        list = new Technology[imgs.length];
        for(int i = 0 ; i < list.length; i++){
            list[i] = new Technology(imgs[i], names[i], subs[i], descs[i]);
        }
    }
}