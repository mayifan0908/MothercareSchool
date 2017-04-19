package com.yf.fengmai.mothercareschool.fragments;

import com.yf.fengmai.mothercareschool.R;
import com.yf.fengmai.mothercareschool.adapters.ContentListAdapter;
import com.yf.fengmai.mothercareschool.beans.BaseBean;
import com.yf.fengmai.mothercareschool.beans.HotBean;

import java.util.ArrayList;

/**
 * Created by fengmai on 2017/4/18.
 */

public class BBSListFragment extends BaseListfragment{
    private ArrayList<BaseBean> mContentList = null;
    private ContentListAdapter contentListAdapter=null;

    public static BBSListFragment newinstance(){
        BBSListFragment f=new BBSListFragment();
        return f;
    }
    @Override
    public void start() {
        mContentList=new ArrayList<>();
        contentListAdapter=new ContentListAdapter(getContext(),mContentList);
        setadapter(contentListAdapter);
        for (int i = 0; i < 8; i++) {
            HotBean hotBean=new HotBean();
            hotBean.setHot_img1(R.drawable.icon_user_name);
            hotBean.setHot_tv("第一眼看到这个绘本的时候，觉得真心太美啦所以分享给大家，名字叫框朵朵");
            hotBean.setHot_img2(R.drawable.image_sign_page);
            mContentList.add(hotBean);
        }
        contentListAdapter.notifyDataSetChanged();
    }
}
