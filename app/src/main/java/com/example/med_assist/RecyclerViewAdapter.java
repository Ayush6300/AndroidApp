package com.example.med_assist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder> {

    Context mContext;
    List<row> mData;

    public RecyclerViewAdapter(Context mContext, List<row> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Glide.
                with(mContext)
                .load(mData.get(position).getImg())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            final Intent intent;
            if (getAdapterPosition() == 0) {
                intent = new Intent(mContext, EndlessMedical.class);
                mContext.startActivity(intent);
            } else if (getAdapterPosition() == 1){
                intent =  new Intent(mContext, Medicines.class);
            mContext.startActivity(intent);
            }
            else if (getAdapterPosition() == 3){
                intent =  new Intent(mContext, Hospital.class);
                mContext.startActivity(intent);
            }
//            else {
//                intent =  new Intent(context, DifferentActivity.class);
//            }
//                mContext.startActivity(intent);

//            if (getAdapterPosition() ==0 ){
//
//                Toast.makeText(mContext, "You Clicked me", Toast.LENGTH_SHORT).show();
//            }

            }
        }
    }

