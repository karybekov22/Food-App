package com.e.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.e.foodapp.R;
import com.e.foodapp.model.Allmenu;

import java.util.List;

public class AllMenuAdapter extends RecyclerView.Adapter<AllMenuAdapter.AllMenuViewHolder> {

    Context context;
    List<Allmenu> allmenuList;

    public AllMenuAdapter(Context context, List<Allmenu> allmenuList) {
        this.context = context;
        this.allmenuList = allmenuList;
    }

    @NonNull
    @Override
    public AllMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.allmenu_recycler_items, parent, false);

        return new AllMenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllMenuViewHolder holder, int position) {

        holder.popularName.setText(allmenuList.get(position).getName());
        holder.popularNote.setText(allmenuList.get(position).getNote());
        holder.popularRating.setText(allmenuList.get(position).getRating());
        holder.popularTime.setText(allmenuList.get(position).getDeliveryTime());
        holder.popularCharges.setText(allmenuList.get(position).getDeliveryCharges());
        holder.popularPrices.setText(allmenuList.get(position).getPrice());

        Glide.with(context).load(allmenuList.get(position).getImageUrl()).into(holder.popularImage);
    }

    @Override
    public int getItemCount() {
        return allmenuList.size();
    }

    public static class AllMenuViewHolder extends RecyclerView.ViewHolder{

        TextView popularName, popularNote, popularRating, popularTime, popularCharges, popularPrices;
        ImageView popularImage;

        public AllMenuViewHolder(@NonNull View itemView) {
            super(itemView);

            popularName = itemView.findViewById(R.id.popular_name);
            popularNote = itemView.findViewById(R.id.popular_note);
            popularRating = itemView.findViewById(R.id.popular_rating);
            popularTime = itemView.findViewById(R.id.popular_deliverytime);
            popularCharges = itemView.findViewById(R.id.popular_delivery_charge);
            popularPrices = itemView.findViewById(R.id.popular_price);

        }
    }
}
