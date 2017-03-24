package com.kyuwankim.android.listviewprac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by kimkyuwan on 2017. 3. 13..
 */

public class ListAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String datas[];

    public ListAdapter(String datas[], Context context){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datas = datas;
    }



    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.listview_item, null);
        }

        TextView tv_maincontent = (TextView) convertView.findViewById(R.id.listview_item_tv_maincontext);
        TextView tv_subcontent = (TextView) convertView.findViewById(R.id.listview_item_tv_subcontext);

        tv_maincontent.setText(datas[position]);
        tv_subcontent.setText(datas[position]+" sub");

        return convertView;
    }
}
