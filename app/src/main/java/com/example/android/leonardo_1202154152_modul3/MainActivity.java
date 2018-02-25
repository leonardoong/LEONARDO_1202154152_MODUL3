package com.example.android.leonardo_1202154152_modul3;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Pendeklarasian attribute
    ArrayList<MerkAir> listAir;
    RecyclerAdapter mAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        int gridColumn = getResources().getInteger(R.integer.grid_column_count);;
        //Grid Layout Manager agar aplikasi dapat mensupport landscape
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColumn));

        listAir = new ArrayList<>();

        mAdapter = new RecyclerAdapter(this, listAir);
        recyclerView.setAdapter(mAdapter);
        //Memanggil method untuk dijalankan
        initialiseData();

    }

    //Method untuk menambahkan data MerkAir yang ada di array
    private void initialiseData() {
        String[] airList = getResources().getStringArray(R.array.name_src);
        String[] airInfo = getResources().getStringArray(R.array.info_src);
        TypedArray airImageResource = getResources().obtainTypedArray(R.array.img_src);
        listAir.clear();

        for (int i=0; i<airList.length; i++){
            listAir.add(new MerkAir(airList[i], airInfo[i], airImageResource.getResourceId(i, 0)));
        }

        airImageResource.recycle();

        mAdapter.notifyDataSetChanged();
    }


}
