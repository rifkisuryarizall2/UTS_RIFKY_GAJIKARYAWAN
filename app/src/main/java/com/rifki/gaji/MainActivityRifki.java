package com.rifki.gaji;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityRifki extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rifki);

        Button btnMenuUtama = findViewById(R.id.btnMenuUtamaRifki);
        Button btnInfoGaji = findViewById(R.id.btnInfoGajiRifki);
        Button btnPetunjuk = findViewById(R.id.btnPetunjukRifki);
        Button btnTentang = findViewById(R.id.btnTentangRifki);
        Button btnExit = findViewById(R.id.btnExitRifki);

        btnMenuUtama.setOnClickListener(v ->
                Toast.makeText(this, "Anda sudah berada di Menu Utama", Toast.LENGTH_SHORT).show());

        btnInfoGaji.setOnClickListener(v ->
                startActivity(new Intent(this, GajiActivityRifki.class)));

        btnPetunjuk.setOnClickListener(v ->
                startActivity(new Intent(this, PetunjukActivityRifki.class)));

        btnTentang.setOnClickListener(v ->
                startActivity(new Intent(this, TentangActivityRifki.class)));

        btnExit.setOnClickListener(v -> finishAffinity());
    }
}
