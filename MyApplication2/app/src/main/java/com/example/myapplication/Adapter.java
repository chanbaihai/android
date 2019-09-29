package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adapter extends RecyclerView.Adapter {
//    public List<Im>  data;
    public List<String> data = new ArrayList<String>();
    Context cox;

    public Adapter(Context cox) {
        this.cox = cox;

        for (Integer in = 1;in<100;in ++){
            data.add(in.toString());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(cox).inflate(R.layout.item,viewGroup,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ImageView iv = (ImageView) viewHolder.itemView.findViewById(R.id.im);
        ImageLoader.getInstance().displayImage("https://cdn.mom1.cn/?mom="+data.get(i), iv);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
//    public List<Im>  data ;
//
//    @Override
//    public int getCount() {
//        return data.size();
//    }
//
//    @Override
//    public Im getItem(int i) {
//        return data.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int po, View view, ViewGroup viewGroup) {
//        View rootv = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,null);
//        ImageView iv = rootv.findViewById(R.id.im);
//        ImageLoader.getInstance().displayImage(getItem(po).img, iv);
//        return rootv;
//    }
}
class RecyclerHolder extends RecyclerView.ViewHolder {
    ImageView iv;

    public RecyclerHolder(View itemView) {
        super(itemView);
        iv = (ImageView) itemView.findViewById(R.id.im);
    }
}