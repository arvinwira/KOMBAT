package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class checkout extends AppCompatActivity {
    private KeranjangAdapter keranjangAdapter;
    private TextView tampilTotalHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        if (keranjangAdapter == null) {
            List<Produk> keranjangObatList = KeranjangManager.getKeranjangObatList();
            keranjangAdapter = new KeranjangAdapter(this, keranjangObatList, tampilTotalHarga);
        }

        Button buttonPay = findViewById(R.id.buttonPay);
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the keranjang when making payment
                KeranjangManager.clearKeranjang();
                Intent intent = new Intent(getApplicationContext(), succes_payment.class);
                startActivity(intent);


            }
        });
    }
}
