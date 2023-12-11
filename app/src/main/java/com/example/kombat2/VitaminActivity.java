package com.example.kombat2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.view.View;

import java.util.Collections;
import java.util.Comparator;

public class VitaminActivity extends AppCompatActivity {

    private RecyclerView recyclerViewVitamin;
    private List<Vitamin> vitaminList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamin);

        // Inisialisasi RecyclerView
        recyclerViewVitamin = findViewById(R.id.recyclerViewVitamin);

        // Mendapatkan data vitamin (contoh data dummy)
        vitaminList = generateDummyVitaminData();

//        // Mengurutkan data vitamin berdasarkan nama secara alfabetis
//        Collections.sort(vitaminList, new Comparator<Vitamin>() {
//            @Override
//            public int compare(Vitamin vitamin1, Vitamin vitamin2) {
//                return vitamin1.getNama().compareToIgnoreCase(vitamin2.getNama());
//            }
//        });

        // Mengatur layout manager dan adapter untuk RecyclerView
        VitaminAdapter vitaminAdapter = new VitaminAdapter(this, vitaminList);
        recyclerViewVitamin.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewVitamin.setAdapter(vitaminAdapter);
    }

    // Button initialization and click listener setup
    public void openDetailVitamin(View view) {
        RecyclerView.ViewHolder viewHolder = recyclerViewVitamin.findContainingViewHolder(view);

        if (viewHolder != null) {
            int clickedPosition = viewHolder.getAdapterPosition();

            if (clickedPosition != RecyclerView.NO_POSITION && clickedPosition < vitaminList.size()) {
                Vitamin selectedVitamin = vitaminList.get(clickedPosition);

                Intent intent = new Intent(this, DetailVitaminActivity.class);
                intent.putExtra("VITAMIN", selectedVitamin);
                startActivity(intent);
            }
        }
    }

    public void klikKembali(View view) {
        onBackPressed(); // Kembali ke halaman sebelumnya
    }
    public void bukaKeranjang(View view) {
        Intent intent = new Intent(this, KeranjangActivity.class);
        startActivity(intent);
    }
    public void bukaNotif(View view) {
        Intent intent = new Intent(VitaminActivity.this, NotifikasiActivity.class);
        startActivity(intent);
    }

    private List<Vitamin> generateDummyVitaminData() {
        List<Vitamin> vitaminList = new ArrayList<>();

        vitaminList.add(new Vitamin("Enervon-C 4 Tablet", "Enervon-C Tablet mengandung vitamin C dan vitamin B kompleks. Suplemen multivitamin ini akan membantu memelihara daya tahan tubuh, membantu proses metabolisme tubuh dalam menghasilkan energi, dan membantu pemulihan tubuh setelah sakit.  ", "Rp. 5.830", R.drawable.imgvitamin_enervonc));
        vitaminList.add(new Vitamin("Enervon Active 4 Tablet", "Membantu menjaga daya tahan tubuh. Mengandung Vitamin C (asam askorbat) 500 mg, niasinamida 50 mg, kalsium pantetonat 20 mg, vitamin B1 (tiamin) 50 mg, vitamin B2 (riboflavin) 25 mg, vitamin B6 (piridoksin) 10 mg, dan vitamin B12 5 mcg.", "Rp. 6.741", R.drawable.imgvitamin_enervoncactive));
        vitaminList.add(new Vitamin("Redoxon Triple Action 10 Tablet", "Kombinasi dari vitamin C, vitamin D, dan zinc dalam Redoxon Triple Action Orange Flavour 10 Tablet Effervescent akan membantu meningkatkan daya tahan tubuh, serta baik untuk menjaga kesehatan kulit, tulang, dan gigi.", "Rp. 53.900", R.drawable.imgvitamin_redoxon));
        vitaminList.add(new Vitamin("Blackmores Vitamin C 500 60 Tablet", "Blackmores Vitamin C 500 Tablet adalah suplemen yang bermanfaat untuk menjaga dan memelihara kesehatan tubuh.", "Rp. 161.975", R.drawable.imgvitamin_blackmores));
        vitaminList.add(new Vitamin("Nature Plus Vitamin C 500 Mg 90 Tablet", "Suplemen yang mengandung vitamin C (ascorbic acid) 500 mg dan rose hips 50 mg. Membantu memelihara kesehatan dan menjaga daya tahan tubuh.", "Rp. 351.218", R.drawable.imgvitamin_natures));
        vitaminList.add(new Vitamin("CDR Effervescent 10 Tablet", "CDR Effervescent 10 Tablet bermanfaat untuk memenuhi kebutuhan kalsium, menjaga tulang agar tetap kuat, membantu masa penyembuhan, dan masa pertumbuhan.", "Rp. 58.850", R.drawable.imgvitamin_cdr));

        return vitaminList;
    }
}

