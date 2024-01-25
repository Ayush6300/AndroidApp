package com.example.med_assist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MedImageRecycleAdapter extends RecyclerView.Adapter<MedImageRecycleAdapter.MyViewHolder> {

    private static List<Medicine_image> dataList;
    private final Listener listener;

    public MedImageRecycleAdapter(List<Medicine_image> dataList, Listener listener) {
        this.dataList = dataList;

        this.listener = listener;
    }

    @NonNull
    @Override
    public MedImageRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_image, parent, false);
        return new MedImageRecycleAdapter.MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MedImageRecycleAdapter.MyViewHolder holder, int position) {

        Medicine_image dataItem = dataList.get(position);

        String ImageUrl;
        ImageUrl = dataItem.getMedicineImage();

        Glide.with(holder.itemView.getContext())
                .load(ImageUrl)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public MyViewHolder( View itemView, Listener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.medicine_recycler_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            listener.onItemClicked(pos);
                        }
                    }
                }
            });
        }
    }
    public static Medicine_image getItem(int position) {
        return dataList.get(position);
    }
}
