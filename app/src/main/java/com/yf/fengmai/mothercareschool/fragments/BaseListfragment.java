package com.yf.fengmai.mothercareschool.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yf.fengmai.mothercareschool.R;
import com.yf.fengmai.mothercareschool.recyclerview.MainRecyclerview;
import com.yf.fengmai.mothercareschool.recyclerview.QQRefreshHeader;
import com.yf.fengmai.mothercareschool.recyclerview.RefreshLayout;


/**
 * Created by fengmai on 2017/4/11.
 */

public abstract class BaseListfragment extends Fragment{
    private View contextview;
    private MainRecyclerview recyclerView;
    private RecyclerView.Adapter madapter;
    private Context context;
    private RefreshLayout refreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contextview =inflater.inflate(R.layout.fragment,null);
        refreshLayout= (RefreshLayout) contextview.findViewById(R.id.refreshLayout);
        findviews();
        return contextview;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // init();
        start();
    }

    private void findviews() {
        recyclerView= (MainRecyclerview) contextview.findViewById(R.id.recyclerView);

    }


    public abstract void start();

    public void setadapter(RecyclerView.Adapter adapter){
            if (adapter!=null){
                madapter=adapter;
                recyclerView.setAdapter(madapter);
                if (refreshLayout!=null){
                    refreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            refreshLayout.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    refreshLayout.refreshComplete();
                                    if (recyclerView!=null){

                                    }
                                }
                            },1500);
                        }
                    });
                }
                QQRefreshHeader header  = new QQRefreshHeader(getContext());
                refreshLayout.setRefreshHeader(header);
                refreshLayout.autoRefresh();
            }
    }
}
