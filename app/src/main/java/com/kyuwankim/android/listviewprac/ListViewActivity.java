package com.kyuwankim.android.listviewprac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    ListView listview;
    String array[] = {"aa", "bb", "cc", "dd", "ee", "ff", "gg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listview = (ListView) findViewById(R.id.listview);
        ListAdapter adapter = new ListAdapter(array, this);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(listener);
    }


    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(ListViewActivity.this, ListViewActivityDetail.class);

            intent.putExtra("maintitle", array[position]);
            intent.putExtra("subtitle", array[position] + " sub");

            startActivity(intent);
        }
    };

}
