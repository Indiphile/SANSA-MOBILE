package com.example.login.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.interfaces.SelectListener;
import com.example.login.model.Farms;

import java.util.List;


public class RecyclerViewAdaptor extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Farms> farms;

    SelectListener selectListener;

    public RecyclerViewAdaptor(Context context, List<Farms> farms, SelectListener selectListener) {
        this.context = context;
        this.farms = farms;
        this.selectListener = selectListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.farmLogo.setImageResource(farms.get(position).getFarmImg());
        holder.farmName.setText(farms.get(position).getFarmName());
        holder.farmLocation.setText(farms.get(position).getFarmName());

        holder.farmDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectListener.onItemClicked(farms.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return farms.size();
    }
}
