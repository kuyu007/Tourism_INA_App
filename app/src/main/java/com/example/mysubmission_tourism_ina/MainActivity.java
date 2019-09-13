package com.example.mysubmission_tourism_ina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageButton ibGrid;
    private ImageButton ibList;
    private RecyclerView rvTourism;
    private ArrayList<Tourism> list;
    private ArrayList<Tourism> listTourism;

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibGrid = findViewById(R.id.imgb_grid);
        ibList = findViewById(R.id.imgb_list);

        rvTourism = findViewById(R.id.recycle_view);
        rvTourism.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(DataTourism.getListData());

        viewRecyclerGrid();
//        viewRecyclerList();

    }

    public void btnListView(View view) {
        viewRecyclerList();
    }

    private void viewRecyclerList(){
        rvTourism.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(this);
        listAdapter.setListTourism(list);
        rvTourism.setAdapter(listAdapter);


    }

    public void btnGridView(View view) {
        viewRecyclerGrid();
    }

    private void viewRecyclerGrid(){
        rvTourism.setLayoutManager(new GridLayoutManager(this,2));
        GridAdapter gridAdapter = new GridAdapter(this);
        gridAdapter.setListTourism(list);
        rvTourism.setAdapter(gridAdapter);
    }

    private ArrayList<Tourism> getListTourism(){
        return listTourism;
    }

}
