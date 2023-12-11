package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class KeranjangActivity extends AppCompatActivity {
    private TextView tampilTotalHarga;
    private RecyclerView recyclerViewKeranjang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        tampilTotalHarga = findViewById(R.id.tampilTotalHarga);


        // Mendapatkan data obat dari keranjang
        List<Produk> keranjangObatList = KeranjangManager.getKeranjangObatList();


        // Mengatur layout manager dan adapter untuk RecyclerView
        KeranjangAdapter keranjangAdapter = new KeranjangAdapter(this, keranjangObatList, tampilTotalHarga);
        RecyclerView recyclerViewKeranjang = findViewById(R.id.recyclerViewKeranjang);
        recyclerViewKeranjang.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewKeranjang.setAdapter(keranjangAdapter);

        // Call updateTotalHarga method to set the initial total harga
        keranjangAdapter.updateTotalHarga();

        Button checkoutButton = findViewById(R.id.checkout);

        // Menambahkan pendengar klik pada tombol Checkout
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat intent untuk memulai aktivitas Checkout
                Intent intent = new Intent(KeranjangActivity.this, checkout.class);
                startActivity(intent);
            }
        });
    }

    public void klikKembali(View view) {
        onBackPressed(); // Kembali ke halaman sebelumnya
    }

    public void lakukanPembayaran(View view) {

        KeranjangManager.clearKeranjang();

        // Perbarui tampilan RecyclerView dan total harga
        KeranjangAdapter keranjangAdapter = (KeranjangAdapter) recyclerViewKeranjang.getAdapter();
        keranjangAdapter.notifyDataSetChanged();
        keranjangAdapter.updateTotalHarga();


    }
}
