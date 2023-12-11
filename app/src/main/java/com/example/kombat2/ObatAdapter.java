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

public class ObatAdapter extends RecyclerView.Adapter<ObatAdapter.ObatViewHolder> {

    private Context context;
    private List<Obat> obatList;

    public ObatAdapter(Context context, List<Obat> obatList) {
        this.context = context;
        this.obatList = obatList;
    }

    @NonNull
    @Override
    public ObatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_obat, parent, false);
        return new ObatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObatViewHolder holder, int position) {
        Obat obat = obatList.get(position);
        holder.textNamaObat.setText(obat.getNama());
        holder.textJenisObat.setText(obat.getJenis());
//        holder.textDeskripsiObat.setText(obat.getDeskripsi());
        holder.textHargaObat.setText(String.valueOf(obat.getHarga()));
        holder.imageObat.setImageResource(obat.getGambarResId());
    }

    @Override
    public int getItemCount() {
        return obatList.size();
    }

    static class ObatViewHolder extends RecyclerView.ViewHolder {
        TextView textNamaObat, textJenisObat, textHargaObat;
        ImageView imageObat;

        ObatViewHolder(@NonNull View itemView) {
            super(itemView);
            textNamaObat = itemView.findViewById(R.id.textNamaObat);
            textJenisObat = itemView.findViewById(R.id.textJenisObat);
//            textDeskripsiObat = itemView.findViewById(R.id.textDeskripsiObat);
            textHargaObat = itemView.findViewById(R.id.textHargaObat);
            imageObat = itemView.findViewById(R.id.imageObat);
        }
    }
}
