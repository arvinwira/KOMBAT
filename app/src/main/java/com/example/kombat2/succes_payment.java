package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class succes_payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_payment);
    }

    public void kembaliKeHome(View view) {
        Intent intent = new Intent(succes_payment.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}