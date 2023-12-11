package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ObatSayaActivity extends AppCompatActivity {
    private RecyclerView recyclerViewObatSaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obat_saya);

        // Mendapatkan data produk dari Intent
        Obat obat = getIntent().getParcelableExtra("OBAT");

        List<Produk> obatSayaList = ObatSayaManager.getObatSayaList();

        ObatSayaAdapter obatSayaAdapter = new ObatSayaAdapter(this, obatSayaList);
        RecyclerView recyclerViewObatSaya = findViewById(R.id.recyclerViewObatSaya);
        recyclerViewObatSaya.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewObatSaya.setAdapter(obatSayaAdapter);
//        Button button_remove = findViewById(R.id.buttonRemove);

//        button_remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                removeFromObatSaya(obat);
//            }
//        });
    }

    public void klikKembali(View view) {
        onBackPressed(); // Kembali ke halaman sebelumnya
    }

//    private void removeFromObatSaya(Obat obat) {
//        ObatSayaManager.removeFromObatSaya(obat);
//        Toast.makeText(this, "Dihapus dari Wishlist", Toast.LENGTH_SHORT).show();
//    }
}

