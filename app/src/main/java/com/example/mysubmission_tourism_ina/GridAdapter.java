package com.example.mysubmission_tourism_ina;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<Tourism> listTourism;

    private ArrayList<Tourism> getListTourism(){
        return listTourism;
    }

    public void setListTourism(ArrayList<Tourism> listTourism){
        this.listTourism= listTourism;
    }

    GridAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public GridAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View gridView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_tourism,parent,false);
        return new GridViewHolder(gridView);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.GridViewHolder holder, int position) {
    final Tourism mtourism = getListTourism().get(position);
    final String titleTourism = mtourism.getTitle();
    final String locationTourism = mtourism.getLocation();
    final String descTourism = mtourism.getDesc();
    final String imgTourism = mtourism.getImg();


        Glide.with(context)
                .load(getListTourism().get(position).getImg())
                .into(holder.ivImg);

    holder.tvTitle.setText(titleTourism);
    holder.tvLocation.setText(locationTourism);
    holder.tvDesc.setText(descTourism);



        holder.gridlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "anda memilih" + mtourism.getTitle(), Toast.LENGTH_SHORT).show();
                Intent detail = new Intent(context, Detail_Tourism.class);
                detail.putExtra("IMG", imgTourism);
                detail.putExtra("TITLE", titleTourism);
                detail.putExtra("LOCATION", locationTourism);
                detail.putExtra("DESCRIPTION", descTourism);
                context.startActivity(detail);
            }
        });




    }

    @Override
    public int getItemCount() {
        return getListTourism().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        CardView gridlayout;
        TextView tvTitle;
        TextView tvLocation;
        TextView tvDesc;
        ImageView ivImg;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvjudul_grid);
            tvLocation = itemView.findViewById(R.id.location_grid);
            tvDesc = itemView.findViewById(R.id.desc_grid);
            ivImg = itemView.findViewById(R.id.ivimg_grid);
            gridlayout = itemView.findViewById(R.id.cv_grid);
        }
    }
}
