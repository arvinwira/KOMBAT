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

public class VitaminAdapter extends RecyclerView.Adapter<VitaminAdapter.ViewHolder> {
    private Context context;
    private List<Vitamin> vitaminList;

    public VitaminAdapter(Context context, List<Vitamin> vitaminList) {
        this.context = context;
        this.vitaminList = vitaminList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vitamin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vitamin vitamin = vitaminList.get(position);
        holder.bind(vitamin);
    }

    @Override
    public int getItemCount() {
        return vitaminList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView namaTextView;
//        private TextView deskripsiTextView;
        private TextView hargaTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.vitaminImageView);
            namaTextView = itemView.findViewById(R.id.NamaVitaminTextView);

            hargaTextView = itemView.findViewById(R.id.HargaVitaminTextView);
        }

        public void bind(Vitamin vitamin) {
            imageView.setImageResource(vitamin.getGambarResId());
            namaTextView.setText(vitamin.getNama());
//            deskripsiTextView.setText(vitamin.getDeskripsi());
            hargaTextView.setText(vitamin.getHarga());
        }
    }
}
