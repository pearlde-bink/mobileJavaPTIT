package com.example.ptitapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tinhBMI extends AppCompatActivity {
    private EditText h1, w1;
    private Button btn;
    private TextView kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tinh_bmi);

        h1 = findViewById(R.id.h1);
        w1 = findViewById(R.id.w1);
        btn = findViewById(R.id.btn);
        kq = findViewById(R.id.kq);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height = h1.getText().toString();
                String weight = w1.getText().toString();
                try {
                    double h1 = Double.parseDouble(height);
                    double w1 = Double.parseDouble(weight);
                    String s = tinh(h1, w1);
                    kq.setText(s);
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

    private String tinh(double s1, double s2){
        String s = "";
        double bmi = s2 / (s1 * s1);
        return s = bmi + "";
    }
}