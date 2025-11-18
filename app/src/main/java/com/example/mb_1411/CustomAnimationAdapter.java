package com.example.mb_1411;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAnimationAdapter extends RecyclerView.Adapter<CustomAnimationAdapter.ViewHolder> {

    private final List<String> mDatas;

    public CustomAnimationAdapter(List<String> data) {
        this.mDatas = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View itemView = li.inflate(R.layout.row_animation, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = mDatas.get(position);
        holder.tvItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addItem(String item) {
        mDatas.add(item);
        notifyItemInserted(mDatas.size() - 1);
    }

    public void addItem(int position, String item) {
        mDatas.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDatas.size());
    }

    public void removeItem(String item) {
        int index = mDatas.indexOf(item);
        if (index < 0) {
            return;
        }
        mDatas.remove(index);
        notifyItemRemoved(index);
        notifyItemRangeChanged(index, mDatas.size());
    }

    public void replaceItem(int position, String item) {
        mDatas.set(position, item);
        notifyItemChanged(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvItem;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);

            itemView.setOnLongClickListener(v -> {
                removeItem(getAdapterPosition());
                Toast.makeText(itemView.getContext(), "Item Removed", Toast.LENGTH_SHORT).show();
                return true;
            });

            itemView.setOnClickListener(v -> {
                replaceItem(getAdapterPosition(), "Item Changed");
                Toast.makeText(itemView.getContext(), "Item Changed", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
