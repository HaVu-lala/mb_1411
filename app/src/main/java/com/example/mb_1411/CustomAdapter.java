package com.example.mb_1411;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private final List<Object> mObjects;

    public static final int TEXT = 0;
    public static final int IMAGE = 1;
    public static final int USER = 2;

    public CustomAdapter(Context context, List<Object> objects) {
        this.mContext = context;
        this.mObjects = objects;
    }

    @Override
    public int getItemViewType(int position) {
        if (mObjects.get(position) instanceof String) {
            return TEXT;
        } else if (mObjects.get(position) instanceof Integer) {
            return IMAGE;
        } else if (mObjects.get(position) instanceof UserModel) {
            return USER;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        switch (viewType) {
            case TEXT:
                View textView = inflater.inflate(R.layout.row_text, parent, false);
                return new TextViewHolder(textView);
            case IMAGE:
                // Assuming you have a layout file named 'row_image.xml' for the image
                View imageView = inflater.inflate(R.layout.row_image, parent, false);
                return new ImageViewHolder(imageView);
            case USER:
                // Assuming you have a layout file named 'row_user.xml' for the user
                View userView = inflater.inflate(R.layout.row_user, parent, false);
                return new UserViewHolder(userView);
        }
        throw new IllegalArgumentException("Invalid view type");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TEXT:
                TextViewHolder textViewHolder = (TextViewHolder) holder;
                textViewHolder.tvText.setText((String) mObjects.get(position));
                break;
            case IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                imageViewHolder.imvImage.setImageResource((Integer) mObjects.get(position));
                break;
            case USER:
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                UserModel user = (UserModel) mObjects.get(position);
                userViewHolder.tvName.setText(user.getName());
                userViewHolder.tvAddress.setText(user.getAddress());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }

    // ViewHolder for Text type
    public class TextViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvText;

        public TextViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(view -> Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show());
        }
    }

    // ViewHolder for Image type
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imvImage;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imvImage = itemView.findViewById(R.id.imv_image);
            itemView.setOnClickListener(view -> Toast.makeText(mContext, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show());
        }
    }

    // ViewHolder for User type
    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvAddress;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            itemView.setOnClickListener(view -> {
                UserModel user = (UserModel) mObjects.get(getAdapterPosition());
                Toast.makeText(mContext, user.getName() + ", " + user.getAddress(), Toast.LENGTH_SHORT).show();
            });
        }
    }
}
