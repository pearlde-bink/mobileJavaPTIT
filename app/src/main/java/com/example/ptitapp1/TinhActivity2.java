package com.example.ptitapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TinhActivity2 extends AppCompatActivity {
    private TextView kq;
    private EditText edit1, edit2;
    private Button btn;
    private Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tinh2);
        initView();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nn1 = edit1.getText().toString();
                String nn2 = edit2.getText().toString();
                double n1, n2;
                try {
                    n1 = Double.parseDouble(nn1);
                    n2 = Double.parseDouble(nn2);
                    String kk = tinhtoan(n1, n2, "+");
                    kq.setText(kk);
                    Toast.makeText(getApplicationContext(), kk, Toast.LENGTH_LONG).show();
                } catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Nhap 2 so", Toast.LENGTH_LONG).show();
                }
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nn1 = edit1.getText().toString();
                String nn2 = edit2.getText().toString();
                double n1, n2;
                try {
                    n1 = Double.parseDouble(nn1);
                    n2 = Double.parseDouble(nn2);
                    String p = sp.getSelectedItem().toString();
                    String kk = tinhtoan(n1, n2, p);
                    kq.setText(kk);
                    Toast.makeText(getApplicationContext(), kk, Toast.LENGTH_LONG).show();
                } catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Nhap 2 so", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initView() {
        kq = findViewById(R.id.kq);
        edit1 = findViewById(R.id.e1);
        edit2 = findViewById(R.id.e2);
        btn= findViewById(R.id.btn);
        sp = findViewById(R.id.sp);
    }

    private String tinhtoan(double x, double y, String p){
        String s = "";
        switch(p){
            case "+": s = "Tong: " + (x + y); break;
            case "-": s = "Hieu: " + (x - y); break;
            case "*": s = "Tich: " + (x * y); break;
            case "/":
                if(y==0) s = "Khong chia duoc cho )";
                else s = "Thuong: " + (x / y); break;
        }
        return s;
    }

    public void add(View v){
        String nn1 = edit1.getText().toString();
        String nn2 = edit2.getText().toString();
        double n1, n2;
        try {
            n1 = Double.parseDouble(nn1);
            n2 = Double.parseDouble(nn2);
//            String phep = "";
//            String kk = tinhtoan(n1, n2, phep);
            String kk = tinhtoan(n1, n2, "+");
            kq.setText(kk);
            Toast.makeText(this, kk, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e){
            throw e;
        }
    }

//    public void add(View v){
//        String nn1 = edit1.getText().toString();
//        String nn2 = edit2.getText().toString();
//        double n1, n2;
//        try {
//            n1 = Double.parseDouble(nn1);
//            n2 = Double.parseDouble(nn2);
//            String kk = tinhtoan(n1, n2, "+");
//            kq.setText(kk);
//            Toast.makeText(this, kk, Toast.LENGTH_LONG).show();
//        } catch (NumberFormatException e){
//            throw e;
//        }
//    }

}