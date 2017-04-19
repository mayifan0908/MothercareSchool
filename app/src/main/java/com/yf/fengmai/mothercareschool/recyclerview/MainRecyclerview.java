package com.yf.fengmai.mothercareschool.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by fengmai on 2017/4/12.
 */

public class MainRecyclerview extends RecyclerView {

    public MainRecyclerview(Context context) {
        super(context);
        init();
    }


    public MainRecyclerview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MainRecyclerview(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setVerticalLinearLayout();
    }
    public void setVerticalLinearLayout() {
        RecyclerViewUtils.setVerticalLinearLayout(this);
    }

    public void setGridLayout(int span) {
        RecyclerViewUtils.setGridLayout(this, span);
    }

    public void setStaggeredGridLayoutManager(int spanCount) {
        RecyclerViewUtils.setStaggeredGridLayoutManager(this, spanCount);
    }
}
