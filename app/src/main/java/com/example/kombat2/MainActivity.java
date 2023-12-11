package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.kombat2.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), WT1.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText("Hai, " + user.getEmail());
        }





        ImageView obatAZButton = findViewById(R.id.imageView7);
        obatAZButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ObatazActivity.class);
                startActivity(intent);
            }
        });

        ImageView vitaminButton = findViewById(R.id.imageView9);
        vitaminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VitaminActivity.class);
                startActivity(intent);
            }
        });


        ImageView obatSayaButton = findViewById(R.id.imageView8);
        obatSayaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ObatSayaActivity.class);
                startActivity(intent);
            }
        });

//        ImageButton homeButton = findViewById(R.id.home);
//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        ImageButton notificationButton = findViewById(R.id.notification);
//        notificationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, NotifikasiActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        ImageButton keranjangButton = findViewById(R.id.keranjang);
//        keranjangButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, KeranjangActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        ImageButton profilButton = findViewById(R.id.profil);
//        profilButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//                startActivity(intent);
//            }
//        });
    }
    public void bukaProfile(View view) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
    public void bukaNotif(View view) {
        Intent intent = new Intent(MainActivity.this, NotifikasiActivity.class);
        startActivity(intent);
    }
    public void bukaKeranjang(View view) {
        Intent intent = new Intent(this, KeranjangActivity.class);
        startActivity(intent);
    }
    public void bukaKupon(View view) {
        Intent intent = new Intent(this, kupon.class);
        startActivity(intent);
    }
    public void bukaObat(View view) {
        Intent intent = new Intent(this, ObatazActivity.class);
        startActivity(intent);
    }
}
