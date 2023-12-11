package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WT2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wt2);
    }

    public void bukaWelcome(View view) {
        Intent intent = new Intent(this, welcome.class);
        startActivity(intent);
    }
    public void bukaWT3(View view) {
        Intent intent = new Intent(this, WT3.class);
        startActivity(intent);
    }
}