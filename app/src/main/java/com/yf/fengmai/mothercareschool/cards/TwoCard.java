package com.yf.fengmai.mothercareschool.cards;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.yf.fengmai.mothercareschool.R;
import com.yf.fengmai.mothercareschool.beans.BaseBean;
import com.yf.fengmai.mothercareschool.beans.ContentBean;


/**
 * Created by fengmai on 2017/4/11.
 */

public class TwoCard extends BaseCard {
    ImageView two_img;

    public TwoCard(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getResId() {
        return R.layout.twolayout;
    }

    @Override
    protected void findViews() {
        two_img = (ImageView) mContentView.findViewById(R.id.two_img);
    }

    @Override
    public void bindData(BaseBean baseBean) {
        if (!(baseBean instanceof ContentBean)) {
            Log.e("myf", "不是contentBean类型");
            return;
        }
        ContentBean contentBean = (ContentBean) baseBean;
        two_img.setImageResource(contentBean.getTwo_img());





    }
}
