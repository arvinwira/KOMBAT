package com.example.kombat2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class KeranjangAdapter extends RecyclerView.Adapter<KeranjangAdapter.ViewHolder> {
    private Context context;
    private List<Produk> keranjangObatList;
    private TextView tampilTotalHarga;

    public KeranjangAdapter(Context context, List<Produk> keranjangObatList, TextView tampilTotalHarga) {
        this.context = context;
        this.keranjangObatList = keranjangObatList;
        this.tampilTotalHarga = tampilTotalHarga;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_keranjang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produk produk = keranjangObatList.get(position);
        int jumlahItem = KeranjangManager.hitungJumlahItem();


        holder.keranjangImageView.setImageResource(produk.getGambarResId());
        holder.keranjangNamaTextView.setText(produk.getNama());
        holder.keranjangHargaTextView.setText(produk.getHarga());



    }

    @Override
    public int getItemCount() {
        return keranjangObatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tampilTotalHarga;
        ImageView keranjangImageView;
        TextView keranjangNamaTextView;
        TextView keranjangHargaTextView;
        TextView textViewQty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            keranjangImageView = itemView.findViewById(R.id.keranjangImageView);
            keranjangNamaTextView = itemView.findViewById(R.id.keranjangNamaTextView);
            keranjangHargaTextView = itemView.findViewById(R.id.keranjangHargaTextView);
            textViewQty = itemView.findViewById(R.id.qty);
        }
    }

    // Method to update total harga
    public void updateTotalHarga() {
        int totalHarga = KeranjangManager.hitungTotalHarga();
        // Format angka sebagai mata uang Indonesia tanpa dua digit nol setelah koma
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
        decimalFormat.setMaximumFractionDigits(0);

        String formattedTotalHarga = decimalFormat.format(totalHarga);

        tampilTotalHarga.setText("Rp. " + formattedTotalHarga);
        notifyDataSetChanged();

    }
}
