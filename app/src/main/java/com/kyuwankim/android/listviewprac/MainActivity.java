package com.kyuwankim.android.listviewprac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_listview;
    Button btn_recyclerview;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_listview = (Button) findViewById(R.id.btn_listview);
        btn_recyclerview = (Button) findViewById(R.id.btn_recyclerview);

        btn_listview.setOnClickListener(this);
        btn_recyclerview.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_listview:
                intent = new Intent(this, ListViewActivity.class);
                break;

            case R.id.btn_recyclerview:
                intent = new Intent(this, RecyclerViewActivity.class);
                break;

        }
        startActivity(intent);
    }
}
