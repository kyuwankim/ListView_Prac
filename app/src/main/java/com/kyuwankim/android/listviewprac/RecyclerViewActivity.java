package com.kyuwankim.android.listviewprac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<User> datas = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        Data data = new Data();
        datas = data.get();

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
        RecyclerViewAdapter rva = new RecyclerViewAdapter(datas, R.layout.recyclerview_item);
        rv.setAdapter(rva);
        rv.setLayoutManager(new LinearLayoutManager(this));



    }
}
