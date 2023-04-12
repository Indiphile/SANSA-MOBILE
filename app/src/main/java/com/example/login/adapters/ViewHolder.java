package com.example.login.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;

public class  ViewHolder extends RecyclerView.ViewHolder {

    TextView farmName;
    TextView farmLocation;
    ImageView farmLogo;

    CardView farmDetails;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        farmLogo = itemView.findViewById(R.id.farmImg);
        farmName = itemView.findViewById(R.id.farmName_txt);
        farmLocation = itemView.findViewById(R.id.farmLoc_txt);
        farmDetails = itemView.findViewById(R.id.farm_details_vc);
    }

}
