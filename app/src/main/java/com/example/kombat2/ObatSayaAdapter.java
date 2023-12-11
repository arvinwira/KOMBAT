package com.example.kombat2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ObatSayaAdapter extends RecyclerView.Adapter<ObatSayaAdapter.ViewHolder> {
    private Context context;
    private List<Produk> obatSayaList;

    public ObatSayaAdapter(Context context, List<Produk> obatSayaList) {
        this.context = context;
        this.obatSayaList = obatSayaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_obat_saya, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produk produk = obatSayaList.get(position);
        holder.bind(produk);
    }

    @Override
    public int getItemCount() {
        return obatSayaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView namaTextView;
        private TextView hargaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.obatSayaImageView);
            namaTextView = itemView.findViewById(R.id.obatSayaNamaTextView);
            hargaTextView = itemView.findViewById(R.id.obatSayaHargaTextView);
        }

        public void bind(Produk produk) {
            imageView.setImageResource(produk.getGambarResId());
            namaTextView.setText(produk.getNama());
            hargaTextView.setText(produk.getHarga());
        }
    }
}
