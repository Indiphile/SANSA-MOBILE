package com.example.login.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.model.Farms;

import java.util.List;


public class RecyclerViewAdaptor extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Farms> farms;

    public RecyclerViewAdaptor(Context context, List<Farms> farms) {
        this.context = context;
        this.farms = farms;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.farmLogo.setImageResource(farms.get(position).getFarmImg());
        holder.farmName.setText(farms.get(position).getFarmName());
        holder.farmLocation.setText(farms.get(position).getFarmName());

    }

    @Override
    public int getItemCount() {
        return farms.size();
    }
}
