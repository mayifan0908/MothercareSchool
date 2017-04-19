package com.yf.fengmai.mothercareschool;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by fengmai on 2017/4/10.
 */

public class HrvAdapter extends RecyclerView.Adapter<HrvAdapter.Myviewholder>{
    private ArrayList<Integer> imgs;
    private LayoutInflater inflater;
    private Context context;

    public HrvAdapter(ArrayList<Integer> imgs, Context context) {
        this.imgs = imgs;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.hrvitemlayout,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
                if (holder instanceof Myviewholder){
                    holder.hrvimg.setImageResource(imgs.get(position));
                }
    }

    @Override
    public int getItemCount() {
        if (imgs!=null){
            return imgs.size();
        }
        return 0;
    }

    class Myviewholder extends RecyclerView.ViewHolder{
        ImageView hrvimg;
        public Myviewholder(View itemView) {
            super(itemView);
            hrvimg= (ImageView) itemView.findViewById(R.id.hrvimg);
        }
    }
}
