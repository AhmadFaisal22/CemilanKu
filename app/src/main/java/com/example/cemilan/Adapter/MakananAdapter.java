package com.example.cemilan.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cemilan.Model.Makanan;
import com.example.cemilan.R;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.ViewHolder> {

    private ArrayList<Makanan> makanans = new ArrayList<>();

    public ArrayList<Makanan> getMakanans() {
        return makanans;
    }

    public void setMakanans(ArrayList<Makanan> makanans) {
        this.makanans = makanans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MakananAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_makanan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananAdapter.ViewHolder holder, int position) {
        holder.bind(makanans.get(position));
    }

    @Override
    public int getItemCount() {
        return makanans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDeskripsi, tvPrice;
        ImageView imageMakanan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDeskripsi = itemView.findViewById(R.id.tvDeskripsi);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            imageMakanan = itemView.findViewById(R.id.imageMakanan);

        }

        void bind(Makanan makanan)
        {
            tvTitle.setText(makanan.getNama());
            tvDeskripsi.setText(makanan.getDeskripsi());
            tvPrice.setText(String.valueOf(makanan.getHarga()));
            Glide.with(itemView.getContext())
                    .load(makanan.getImg())
                    .into(imageMakanan);
        }
    }
}
