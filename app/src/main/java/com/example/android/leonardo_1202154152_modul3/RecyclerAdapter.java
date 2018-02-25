package com.example.android.leonardo_1202154152_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Leonardo on 2/25/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<MerkAir> mMerkData;
    private Context mCtx;

    //Method/Constructor pada class RecyclerAdapter
    public RecyclerAdapter (Context mCtx, ArrayList<MerkAir> mMerkData){
        this.mCtx = mCtx;
        this.mMerkData = mMerkData;
    }

    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_items, null);
        return new RecyclerViewHolder(view);
    }
    //Mehtod agar ketika salah satu merk air diklik maka akan muncul DetailActivity yang berisi detail dari yang dipilih
    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {
        final MerkAir currentAir = mMerkData.get(position);

        holder.judul.setText(currentAir.getNama());
        holder.info.setText(currentAir.getInfo());
        holder.gambar.setImageDrawable(mCtx.getResources().getDrawable(currentAir.getGambar()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mCtx, DetailActivity.class);
                intent.putExtra("judul", currentAir.getNama());
                intent.putExtra("info", currentAir.getInfo());
                intent.putExtra("gambar", currentAir.getGambar());
                mCtx.startActivity(intent);
            }
        });
    }

    //Method untuk menghitung jumlah list merkair
    @Override
    public int getItemCount() {
        return mMerkData.size();
    }

    //Class untuk recycleviewholder
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView judul, info;
        ImageView gambar;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
            judul = itemView.findViewById(R.id.judul);
            info = itemView.findViewById(R.id.info);

        }
    }
}
