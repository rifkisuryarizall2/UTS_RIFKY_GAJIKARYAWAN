package com.rifki.gaji;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PetunjukActivityRifki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_rifki);

        Button btnKembali = findViewById(R.id.btnKembaliPetunjukRifki);
        btnKembali.setOnClickListener(v -> finish());
    }
}
