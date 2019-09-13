package com.example.mysubmission_tourism_ina;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context context;
    private ArrayList<Tourism> listTourism;

    private ArrayList<Tourism> getListTourism(){
    return listTourism;
    }

    public void setListTourism(ArrayList<Tourism> listTourism){
        this.listTourism = listTourism;
    }

    ListAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_tourism, parent, false);


        return new ListViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
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


    holder.listLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Toast.makeText(context, "anda memilih " +  mtourism.getTitle(), Toast.LENGTH_SHORT).show();
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

    public class ListViewHolder extends RecyclerView.ViewHolder {


        CardView listLayout;
        LinearLayout linearLayout;
        TextView tvTitle;
        TextView tvLocation;
        TextView tvDesc;
        ImageView ivImg;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvjudul_list);
            tvLocation = itemView.findViewById(R.id.tvlocation_list);
            tvDesc = itemView.findViewById(R.id.tvdesc_list);
            ivImg = itemView.findViewById(R.id.ciimg_list);
            listLayout = itemView.findViewById(R.id.cv_list);
            linearLayout = itemView.findViewById(R.id.list_linear);
        }
    }
}
