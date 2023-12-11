package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class NotifikasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);
    }

    public void klikKembali(View view) {
        onBackPressed(); // Kembali ke halaman sebelumnya
    }

}