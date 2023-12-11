package com.example.kombat2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObatazActivity extends AppCompatActivity {

    private RecyclerView recyclerViewObatAZ;
    private List<Obat> obatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obataz);

        // Inisialisasi RecyclerView
        recyclerViewObatAZ = findViewById(R.id.recyclerViewObatAZ);

        // Mendapatkan data obat (contoh data dummy)
        obatList = generateDummyData();

//        // Mengurutkan data obat berdasarkan nama secara alfabetis
//        Collections.sort(obatList, new Comparator<Obat>() {
//            @Override
//            public int compare(Obat obat1, Obat obat2) {
//                return obat1.getNama().compareToIgnoreCase(obat2.getNama());
//            }
//        });

        // Mengatur layout manager dan adapter untuk RecyclerView
        ObatAdapter obatAdapter = new ObatAdapter(this, obatList);
        recyclerViewObatAZ.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewObatAZ.setAdapter(obatAdapter);
    }

    // Button initialization and click listener setup
    public void openDetailObat(View view) {
        RecyclerView.ViewHolder viewHolder = recyclerViewObatAZ.findContainingViewHolder(view);

        if (viewHolder != null) {
            int clickedPosition = viewHolder.getAdapterPosition();

            List<Obat> obatList = generateDummyData();
            if (clickedPosition != RecyclerView.NO_POSITION && clickedPosition < obatList.size()) {
                Obat selectedObat = obatList.get(clickedPosition);

                Intent intent = new Intent(this, DetailObatActivity.class);
                intent.putExtra("OBAT", selectedObat);
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
        Intent intent = new Intent(ObatazActivity.this, NotifikasiActivity.class);
        startActivity(intent);
    }


    private List<Obat> generateDummyData() {
        List<Obat> obatList = new ArrayList<>();

        obatList.add(new Obat("Sangobion", "Obat Bebas", "Sangobion 10 Kapsul mengandung kombinasi zat besi, asam folat, vitamin B6, vitamin B12,dan vitamin C yang berperan dalam pembentukan sel darah merah. ", "Rp. 21.890", R.drawable.imgobat_sangobion));
        obatList.add(new Obat("Degirol 0,25 Mg 10 Tablet", "Obat Bebas", "Degirol 0,25 mg Tablet mengandung bahan aktif dequalinium chloride. Dequalinium chloride memiliki sifat antiseptik yang bekerja dengan cara membunuh bakteri dan jamur penyebab infeksi ringan pada mulut dan tenggorokan. ", "Rp. 14.300", R.drawable.imgobat_degirol));
        obatList.add(new Obat("Tempra Drop 15 Ml", "Obat Bebas", "Tempra Drop Rasa Anggur mengandung paracetamol. Obat ini bekerja pada otak untuk menurunkan suhu tubuh dan meningkatkan toleransi terhadap nyeri. Pada umumnya, Tempra ditujukan untuk anak-anak. Meski begitu, orang dewasa juga dapat mengonsumsinya bila bentuk sediaan lain tidak memungkinkan.", "Rp. 57.090", R.drawable.imgobat_tempra));
        obatList.add(new Obat("Polysilane Suspensi 100 Ml", "Obat Bebas", "Polysilane Suspensi 100 ml bermanfaat untuk mengurangi mual, sakit perut, atau kembung, akibat sakit maag, tukak lambung, atau radang lambung.", "Rp. 28.380", R.drawable.imgobat_polisylane));
        obatList.add(new Obat("Bisolvon Extra Peppermint Sirup 60 Ml", "Obat Bebas Terbatas", "Bisolvon Extra Rasa Peppermint Sirup 60 ml mengandung bromhexine dan guafenesin yang membantu mengencerkan dahak di saluran pernapasan (mukolitik) sehingga lebih mudah dikeluarkan.", "Rp. 59.565", R.drawable.imgobat_bisolvon));
        obatList.add(new Obat("Sanmol Forte 250 Mg Sirup 60 Ml", "Obat Bebas", "Sanmol Sirup 60 Ml bekerja dengan cara mengurangi produksi zat penyebab peradangan, yaitu prostaglandin. Penurunan kadar prostaglandin di dalam tubuh akan membuat tanda peradangan seperti demam dan nyeri berkurang.", "Rp. 37.290", R.drawable.imgobat_sanmol));
        obatList.add(new Obat("Diatabs", "Obat Bebas Terbatas", "Diatabs adalah obat antidiare yang diproduksi oleh Medifarma Laboratories. ", "Rp. 4.500", R.drawable.product1_diatabs));

        return obatList;
    }
}
