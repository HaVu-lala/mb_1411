package com.example.mb_1411;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private final List<SongModel> mSongs;
    private final LayoutInflater mLayoutInflater;

    public SongAdapter(Context context, List<SongModel> datas) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mSongs = datas;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate view from row_item_song.xml
        View itemView = mLayoutInflater.inflate(R.layout.row_item_song, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        // Get song in mSong via position
        SongModel song = mSongs.get(position);

        //bind data to viewHolder
        holder.tvCode.setText(song.getmCode());
        holder.tvTitle.setText(song.getTitle());
        holder.tvLyric.setText(song.getLyric());
        holder.tvArtist.setText(song.getmArtist());
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCode;
        private final TextView tvTitle;
        private final TextView tvLyric;
        private final TextView tvArtist;

        public SongViewHolder(View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvLyric = itemView.findViewById(R.id.tv_lyric);
            tvArtist = itemView.findViewById(R.id.tv_artist);
        }
    }
}
