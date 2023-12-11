package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WT1 extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wt1);


    }
    public void bukaWelcome(View view) {
        Intent intent = new Intent(this, welcome.class);
        startActivity(intent);
    }
    public void bukaWT2(View view) {
        Intent intent = new Intent(this, WT2.class);
        startActivity(intent);
    }
}