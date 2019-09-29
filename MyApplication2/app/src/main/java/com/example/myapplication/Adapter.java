package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adapter extends BaseAdapter {
    public List<Im>  data ;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Im getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int po, View view, ViewGroup viewGroup) {
        View rootv = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,null);
        ImageView iv = rootv.findViewById(R.id.im);
        ImageLoader.getInstance().displayImage(getItem(po).img, iv);
        return rootv;
    }
}
