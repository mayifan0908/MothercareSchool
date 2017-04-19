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

public class VrvAdapter extends RecyclerView.Adapter<VrvAdapter.Myviewholder2>{
    private ArrayList<Integer> vimgs;
    private LayoutInflater inflater;
    private Context context;

    public VrvAdapter(ArrayList<Integer> vimgs, Context context) {
        this.vimgs = vimgs;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public Myviewholder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.vrvitemlayout,parent,false);
        return new Myviewholder2(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder2 holder, int position) {
        if (holder instanceof Myviewholder2){
            holder.vitemimg.setImageResource(vimgs.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (vimgs!=null){
            return vimgs.size();
        }
        return 0;
    }

    class Myviewholder2 extends RecyclerView.ViewHolder{
        ImageView vitemimg;
        public Myviewholder2(View itemView) {
            super(itemView);
            vitemimg= (ImageView) itemView.findViewById(R.id.vitemimg);
        }
    }
}
