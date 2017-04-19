package com.yf.fengmai.mothercareschool.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.yf.fengmai.mothercareschool.R;
import com.yf.fengmai.mothercareschool.beans.BaseBean;
import com.yf.fengmai.mothercareschool.beans.HotBean;

/**
 * Created by fengmai on 2017/4/18.
 */

public class HotCard extends BaseCard{
    private ImageView hot_img1,hot_img2;
    private TextView hot_tv;
    public HotCard(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getResId() {
        return R.layout.hotlayout;
    }

    @Override
    protected void findViews() {
        hot_img1= (ImageView) findViewById(R.id.hot_img1);
        hot_img2= (ImageView) findViewById(R.id.hot_img2);
        hot_tv= (TextView) findViewById(R.id.hot_tv);
    }

    @Override
    public void bindData(BaseBean baseBean) {
        if (baseBean==null){
            Log.e("myf","不是CategoryBean类型");
            return;
        }
        HotBean  hotBean= (HotBean) baseBean;
        hot_img1.setImageResource(hotBean.getHot_img1());
        hot_img2.setImageResource(hotBean.getHot_img2());
        hot_tv.setText(hotBean.getHot_tv());

    }
}
