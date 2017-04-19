package com.yf.fengmai.mothercareschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fengmai on 2017/4/15.
 */

public class ListAdapter extends BaseAdapter{
     private ArrayList<String> list;
    private   Context context;
    private LayoutInflater inflater;

    public ListAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (list!=null){
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list!=null){
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        myviewholder holder=null;
        if (convertView==null){
            holder=new myviewholder();
            convertView=inflater.inflate(R.layout.listitem,null);
            holder.list_itemtv= (TextView) convertView.findViewById(R.id.list_itemtv);
            convertView.setTag(holder);

        }else {
            holder= (myviewholder) convertView.getTag();
        }
        holder.list_itemtv.setText(list.get(position));
        return convertView;
    }
    class myviewholder {
        TextView list_itemtv;
    }
}
