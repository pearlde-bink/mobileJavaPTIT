package com.example.ptitapp1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main1 extends AppCompatActivity {
    private CheckBox ck1, ck2, ck3;
    private RadioButton g1, g2;
    private RatingBar rt;
    private Spinner sp;
    private EditText edt;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ex4_layout);
        initView();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ss = "Check box: ";
                if(ck1.isChecked()){
                    ss += ck1.getText() + ", ";
                }
                if(ck2.isChecked()){
                    ss += ck2.getText() + ", ";
                }
                if(ck3.isChecked()){
                    ss += ck3.getText() + ", ";
                }

                if(ss.endsWith(",")){
                    ss = ss.substring(0, ss.length()-2);
                }

                ss += "\nGioi tinh: ";
                if(g1.isChecked()){
                    ss += g1.getText();
                } else {
                    ss += g2.getText();
                }

                ss += "\nRating: " + rt.getRating();

                ss += "\n" + sp.getSelectedItem().toString();

                ss += "\nIdea: " + edt.getText();

                tv.setText(ss);

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initView(){
        ck1 = findViewById(R.id.ckIphone);
        ck2 = findViewById(R.id.ckAndroid);
        ck3 = findViewById(R.id.ckWinMobile);
        g1 = findViewById(R.id.male);
        g2 = findViewById(R.id.female);
        rt = findViewById(R.id.rtStar);
        sp = findViewById(R.id.spinner);
        edt = findViewById(R.id.edt);
        tv = findViewById(R.id.kq);
        btn = findViewById(R.id.btnSubmit);
    }
}
