package com.example.caloriecare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String exerlist[];
    int exericon[];
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String [] exer_list,int [] exer_icon){
        this.context = ctx;
        this.exerlist=exer_list;
        this.exericon=exer_icon;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return exerlist.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.exercise_ui,null);
        TextView txtView = (TextView) convertView.findViewById(R.id.exer_name);
        ImageView exerimg = (ImageView) convertView.findViewById(R.id.exericon);
        txtView.setText(exerlist[i]);
        exerimg.setImageResource(exericon[i]);
        return convertView;
    }
}
