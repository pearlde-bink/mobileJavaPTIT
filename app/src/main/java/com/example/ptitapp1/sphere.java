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
    private EditText r;
    private RadioButton area, volume;
    private Button btn;
    private TextView kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sphere);

        r = findViewById(R.id.rad);
        area = findViewById(R.id.area);
        volume = findViewById(R.id.volume);
        btn = findViewById(R.id.btn);
        kq = findViewById(R.id.kq);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rad = r.getText().toString();
                try {
                    double r = Double.parseDouble(rad);
                    if(area.isChecked()){
                        String kk = dientich(r);
                        kq.setText(kk);
                    } else if(volume.isChecked()){
                        String kk = tt(r);
                        kq.setText(kk);
                    }
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

    private String dientich(double r){
        double a = 4*3.14*r*r;
        return a +"";
    }

    private String tt(double r){
        double v = 4/3*3.14*r*r*r;
        return v +"";
    }
}