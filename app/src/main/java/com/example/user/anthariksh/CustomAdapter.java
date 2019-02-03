package com.example.user.anthariksh;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {

    private Activity c;
    private List<Article> timesOfIndias= new ArrayList<>();

    public CustomAdapter(Activity c, List<Article> timesOfIndias) {
        this.c = c;
        this.timesOfIndias = timesOfIndias;
    }

    @Override
    public int getCount() {
        return timesOfIndias.size();
    }

    @Override
    public Object getItem(int position) {
        return timesOfIndias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // View view = LayoutInflater.from(c).inflate(R.layout.view_layout,parent,false);
        LayoutInflater inflater = c.getLayoutInflater();
        View view=inflater.inflate(R.layout.view_layout,null,false);
        ImageView imageView =view.findViewById(R.id.img_view);
        TextView textView = view.findViewById(R.id.title);
        TextView textView1=view.findViewById(R.id.descrption);
        if(timesOfIndias.get(position)!=null && timesOfIndias.get(position).getDescription()!=null)
        {
            textView1.setText(timesOfIndias.get(position).getDescription());
        }
        if (timesOfIndias.get(position) != null && timesOfIndias.get(position).getTitle() != null)
            textView.setText(timesOfIndias.get(position).getTitle());
        if (timesOfIndias.get(position) != null && timesOfIndias.get(position).getUrlToImage() != null)
            Glide.with(c).load(timesOfIndias.get(position).getUrlToImage()).into(imageView);
        return view;
    }
}
