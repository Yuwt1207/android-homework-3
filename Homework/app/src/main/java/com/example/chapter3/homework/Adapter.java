package com.example.chapter3.homework;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {


    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(parent.getContext(),R.layout.item,null);
            holder.tv=convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        holder.tv.setText("这是第"+String.valueOf(position+1)+"个好友");
        return convertView;
    }

    private static class ViewHolder{
        private TextView tv;
    }

}
