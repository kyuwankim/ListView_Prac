package com.kyuwankim.android.listviewprac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ListViewActivityDetail extends AppCompatActivity {

    TextView maincontent, subcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_detail);

        maincontent = (TextView) findViewById(R.id.tv_listview_maincontent_detail);
        subcontent = (TextView) findViewById(R.id.tv_listview_subcontent_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String main = bundle.getString("maintitle");
        String sub = bundle.getString("subtitle");

        maincontent.setText(main);
        subcontent.setText(sub);

    }
}
