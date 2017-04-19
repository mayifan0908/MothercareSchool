package com.yf.fengmai.mothercareschool.fragments;

import com.yf.fengmai.mothercareschool.R;
import com.yf.fengmai.mothercareschool.adapters.ContentListAdapter;
import com.yf.fengmai.mothercareschool.beans.BaseBean;
import com.yf.fengmai.mothercareschool.beans.CategoryBean;
import com.yf.fengmai.mothercareschool.beans.ContentBean;

import java.util.ArrayList;

/**
 * Created by fengmai on 2017/4/11.
 */

public class MainListFragment extends BaseListfragment{
    private ArrayList<BaseBean> mContentList = null;
    private ContentListAdapter contentListAdapter=null;

     public static MainListFragment newinstance(){
         MainListFragment f=new MainListFragment();
         return f;
     }


    @Override
    public void start() {
        mContentList=new ArrayList<>();
        contentListAdapter=new ContentListAdapter(getContext(),mContentList);
        setadapter(contentListAdapter);
        ContentBean contentBean=new ContentBean();
        contentBean.setTwo_img(R.mipmap.ic_launcher);
        mContentList.add(contentBean);
        for (int i = 0; i < 5; i++) {
            CategoryBean categoryBean=new CategoryBean();
            categoryBean.setCmake_tv("自然之中有太多的奇迹和感动，现代人生活在钢筋混泥土深林里");
            categoryBean.setCmake_img(R.drawable.ic_launcher);
            mContentList.add(categoryBean);
        }
        contentListAdapter.notifyDataSetChanged();

    }


}
