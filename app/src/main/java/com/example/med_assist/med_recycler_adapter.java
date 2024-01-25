package com.example.med_assist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class med_recycler_adapter extends RecyclerView.Adapter<med_recycler_adapter.MyViewHolder> {

    ArrayList<medItems> imagesArrayList;
    private static List<medItems> dataList;
    private final Listener listener;

    public med_recycler_adapter(List<medItems> dataList, Listener listener) {
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public med_recycler_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.med_recycler, parent, false);
        return new MyViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull med_recycler_adapter.MyViewHolder holder, int position) {

        medItems dataItem = dataList.get(position);
//        holder.imageView.setImageResource(dataItem.getImageRes());
        holder.textViewName.setText(dataItem.getName());
        holder.textViewDescription.setText(dataItem.getDescription());
        holder.mrp.setText(dataItem.getMrp());
        holder.FinalPrice.setText(dataItem.getFinalPrice());
        holder.Discount.setText(dataItem.getDiscount());

        String ImageUrl;
        ImageUrl = dataItem.getImageRes();

        Glide.with(holder.itemView.getContext())
                .load(ImageUrl)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewName, mrp, FinalPrice, Discount;
        TextView textViewDescription;

        public MyViewHolder(View itemView, Listener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.med_img_recycle);
            textViewName = itemView.findViewById(R.id.med_text_recycle);
            textViewDescription = itemView.findViewById(R.id.med_desc_recycle);
            mrp = itemView.findViewById(R.id.med_price_recycle);
            FinalPrice = itemView.findViewById(R.id.med_finalPrice_recycle);
            Discount = itemView.findViewById(R.id.med_Discount_recycle);

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
    public static medItems getItem(int position) {
        return dataList.get(position);
    }
}
