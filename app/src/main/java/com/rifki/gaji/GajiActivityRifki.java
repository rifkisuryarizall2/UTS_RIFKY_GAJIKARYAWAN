package com.rifki.gaji;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class GajiActivityRifki extends AppCompatActivity {

    private static final long TUNJANGAN_MAKAN_PER_HARI = 10000;
    private static final long TUNJANGAN_TRANSPORT_PER_HARI = 5000;
    private static final double PAJAK = 0.10;

    private EditText etNik, etNama, etGajiPokok, etTunjanganJabatan, etHariKerja;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_rifki);

        etNik = findViewById(R.id.etNikRifki);
        etNama = findViewById(R.id.etNamaRifki);
        etGajiPokok = findViewById(R.id.etGajiPokokRifki);
        etTunjanganJabatan = findViewById(R.id.etTunjanganJabatanRifki);
        etHariKerja = findViewById(R.id.etHariKerjaRifki);
        tvHasil = findViewById(R.id.tvHasilRifki);

        Button btnHitung = findViewById(R.id.btnHitungRifki);
        Button btnReset = findViewById(R.id.btnResetRifki);
        Button btnKembali = findViewById(R.id.btnKembaliRifki);

        btnHitung.setOnClickListener(v -> hitung());
        btnReset.setOnClickListener(v -> reset());
        btnKembali.setOnClickListener(v -> finish());
    }

    private void hitung() {
        String nik = etNik.getText().toString().trim();
        String nama = etNama.getText().toString().trim();
        String sGajiPokok = etGajiPokok.getText().toString().trim();
        String sTunjanganJabatan = etTunjanganJabatan.getText().toString().trim();
        String sHariKerja = etHariKerja.getText().toString().trim();

        if (nik.isEmpty() || nama.isEmpty() || sGajiPokok.isEmpty()
                || sTunjanganJabatan.isEmpty() || sHariKerja.isEmpty()) {
            Toast.makeText(this, "Semua data harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        long gajiPokok, tunjanganJabatan, hariKerja;
        try {
            gajiPokok = Long.parseLong(sGajiPokok);
            tunjanganJabatan = Long.parseLong(sTunjanganJabatan);
            hariKerja = Long.parseLong(sHariKerja);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Angka yang dimasukkan tidak valid", Toast.LENGTH_SHORT).show();
            return;
        }

        long tunjanganMakan = hariKerja * TUNJANGAN_MAKAN_PER_HARI;
        long tunjanganTransport = hariKerja * TUNJANGAN_TRANSPORT_PER_HARI;
        long gajiKotor = gajiPokok + tunjanganJabatan + tunjanganMakan + tunjanganTransport;
        double pajak = gajiKotor * PAJAK;
        double gajiBersih = gajiKotor - pajak;

        String hasil = "NIK : " + nik + "\n"
                + "Nama : " + nama + "\n\n"
                + "Tunjangan Makan : " + rupiah(tunjanganMakan) + "\n"
                + "Tunjangan Transport : " + rupiah(tunjanganTransport) + "\n"
                + "Gaji Kotor : " + rupiah(gajiKotor) + "\n"
                + "Pajak (10%) : " + rupiah(pajak) + "\n"
                + "Gaji Bersih : " + rupiah(gajiBersih);
        tvHasil.setText(hasil);
    }

    private void reset() {
        etNik.setText("");
        etNama.setText("");
        etGajiPokok.setText("");
        etTunjanganJabatan.setText("");
        etHariKerja.setText("");
        tvHasil.setText("");
        etNik.requestFocus();
    }

    private String rupiah(double angka) {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
        nf.setMaximumFractionDigits(0);
        return "Rp " + nf.format(angka);
    }
}
