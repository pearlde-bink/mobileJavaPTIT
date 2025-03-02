package com.example.ptitapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sphere extends AppCompatActivity {
    private EditText r, h;
    private Button btn;
    private TextView kqa, kqv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);

        r = findViewById(R.id.radVal);
        h = findViewById(R.id.heightVal);
        btn = findViewById(R.id.btn);
        kqa = findViewById(R.id.kqa);
        kqv = findViewById(R.id.kqv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rad = r.getText().toString();
                String height = h.getText().toString();
                try {
                    double r = Double.parseDouble(rad);
                    double h = Double.parseDouble(height);
                    String kk1 = area(r, h);
                    kqa.setText(kk1);

                    String kk2 = volume(r, h);
                    kqv.setText(kk2);
                } catch (NumberFormatException e){
                    System.out.println(e);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private String area(double radius, double height) {
        // Using the provided value of π
//        double pi = 3.14159265;
//
//        // Calculate the slant height using Pythagorean theorem: √(r² + h²)
//        double slantHeight = Math.sqrt(radius * radius + height * height);
//
//        // Calculate surface area: πr² + πr√(r² + h²)
//        double surfaceArea = (Math.PI * radius * radius) + Math.PI * radius * slantHeight;
//
//        return "Surface area = " + surfaceArea;
        // Chuyển đổi sang kiểu số
//        double r = Double.parseDouble(radius);
//        double h = Double.parseDouble(height);

        // Tính toán
        double volume = (1.0 / 3.0) * Math.PI * radius * radius * height;  // Thể tích hình nón
        double slantHeight = Math.sqrt(radius * radius + height * height);      // Độ dài đường sinh
        double surfaceArea = Math.PI * radius * (radius + slantHeight); // Diện tích xung quanh

        // Hiển thị kết quả
//        resultVolume.setText(String.format("%.5f", volume));
//        resultSurfaceArea.setText(String.format("%.5f", surfaceArea));
        String s = String.format("%.5f", surfaceArea);
        return "Area = " + s;
    }
    private String volume(double radius, double height) {
        // Using the provided value of π
        double pi = 3.14159265;

        // Calculate volume using formula: (1/3)πr²h
        double volume = (1.0/3.0) * Math.PI * radius * radius * height;
        String s= String.format("%.5f", volume);
        return "Volume = " + s;
    }
}