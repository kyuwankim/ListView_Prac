package com.kyuwankim.android.listviewprac;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kimkyuwan on 2017. 3. 13..
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    ArrayList<User> datas ;
    int itemlayout;

    public RecyclerViewAdapter(ArrayList<User> datas, int itemlayout) {
        this.datas = datas;
        this.itemlayout = itemlayout;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemlayout, parent, false);

        RecyclerViewHolder rvh = new RecyclerViewHolder(view);
        return rvh;
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        User user = datas.get(position);

        holder.recyclerview_tv_maincontent.setText(user.id+"");
        holder.recyclerview_tv_subcontent.setText(user.name + " sub");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView recyclerview_tv_maincontent, recyclerview_tv_subcontent;

        public RecyclerViewHolder(View view) {
            super(view);

            recyclerview_tv_maincontent = (TextView) view.findViewById(R.id.recyclerview_item_tv_maincontext);
            recyclerview_tv_subcontent = (TextView) view.findViewById(R.id.recyclerview_item_tv_subcontext);
        }
    }
}
