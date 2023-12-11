package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailObatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_obat);

        // Mendapatkan data produk dari Intent
        Obat obat = getIntent().getParcelableExtra("OBAT");

        // Inisialisasi komponen-komponen pada layout detail
        ImageView imageView = findViewById(R.id.detailImageView);
        TextView namaTextView = findViewById(R.id.detailNamaTextView);
        TextView deskripsiTextView = findViewById(R.id.detailDeskripsiTextView);
        TextView hargaTextView = findViewById(R.id.detailHargaTextView);
        TextView wishlistButton = findViewById(R.id.wishlistButton);
        Button keranjangButton = findViewById(R.id.keranjangButton);

        // Set nilai dari data produk ke komponen-komponen tampilan
        imageView.setImageResource(obat.getGambarResId());
        namaTextView.setText(obat.getNama());
        deskripsiTextView.setText(obat.getDeskripsi());
        hargaTextView.setText(obat.getHarga());

        wishlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToWishlist(obat);
            }
        });

        keranjangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToKeranjang(obat);
            }
        });
    }

    private void addToWishlist(Obat obat) {
        ObatSayaManager.addToObatSaya(obat);
        Toast.makeText(this, "Ditambahkan ke Wishlist", Toast.LENGTH_SHORT).show();
    }

    private void addToKeranjang(Obat obat) {
        KeranjangManager.addToKeranjang(obat);

        Toast.makeText(this, "Ditambahkan ke Keranjang", Toast.LENGTH_SHORT).show();
    }

    public void klikKembali(View view) {
        onBackPressed(); // Kembali ke halaman sebelumnya
    }


}
