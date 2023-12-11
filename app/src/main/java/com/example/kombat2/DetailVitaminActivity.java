package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailVitaminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vitamin);

        Vitamin vitamin = getIntent().getParcelableExtra("VITAMIN");

        ImageView imageView = findViewById(R.id.detailVitaminImageView);
        TextView namaTextView = findViewById(R.id.detailNamaVitaminTextView);
        TextView deskripsiTextView = findViewById(R.id.detailDeskripsiVitaminTextView);
        TextView hargaTextView = findViewById(R.id.detailHargaVitaminTextView);
        TextView wishlistButton = findViewById(R.id.wishlistVitaminButton);
        Button keranjangButton = findViewById(R.id.keranjangVitaminButton);

        imageView.setImageResource(vitamin.getGambarResId());
        namaTextView.setText(vitamin.getNama());
        deskripsiTextView.setText(vitamin.getDeskripsi());
        hargaTextView.setText(vitamin.getHarga());

        wishlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToWishlist(vitamin);
            }
        });

        keranjangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToKeranjang(vitamin);
            }
        });
    }

    private void addToWishlist(Vitamin vitamin) {
        ObatSayaManager.addToObatSaya(vitamin);



        Toast.makeText(this, "Ditambahkan ke Wishlist", Toast.LENGTH_SHORT).show();
    }

    private void addToKeranjang(Vitamin vitamin) {

        KeranjangManager.addToKeranjang(vitamin);

        Toast.makeText(this, "Ditambahkan ke Keranjang", Toast.LENGTH_SHORT).show();
    }

    public void klikKembali(View view) {
        onBackPressed(); // Kembali ke halaman sebelumnya
    }

}
