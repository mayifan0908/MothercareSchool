package com.yf.fengmai.mothercareschool.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.yf.fengmai.mothercareschool.R;
import com.yf.fengmai.mothercareschool.beans.BaseBean;
import com.yf.fengmai.mothercareschool.beans.CategoryBean;


/**
 * Created by fengmai on 2017/4/11.
 */

public class CmakeCard extends BaseCard{
    TextView cmake_tv;
    ImageView cmake_img;
    public CmakeCard(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getResId() {
        return R.layout.cmakelayout;
    }

    @Override
    protected void findViews() {
        cmake_tv= (TextView)mContentView. findViewById(R.id.cmake_tv);
        cmake_img= (ImageView) mContentView. findViewById(R.id.cmake_img);
    }

    @Override
    public void bindData(BaseBean baseBean) {
        if (!(baseBean instanceof CategoryBean)){
            Log.e("myf","不是CategoryBean类型");
            return;
        }
            CategoryBean categoryBean= (CategoryBean) baseBean;
        cmake_tv.setText(categoryBean.getCmake_tv());
        cmake_img.setImageResource(categoryBean.getCmake_img());




    }
}
