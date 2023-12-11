package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void bukaLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void bukaRegister(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}