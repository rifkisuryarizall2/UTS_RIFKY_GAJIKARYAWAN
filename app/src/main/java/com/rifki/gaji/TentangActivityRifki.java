package com.rifki.gaji;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TentangActivityRifki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_rifki);

        Button btnKembali = findViewById(R.id.btnKembaliTentangRifki);
        btnKembali.setOnClickListener(v -> finish());
    }
}
