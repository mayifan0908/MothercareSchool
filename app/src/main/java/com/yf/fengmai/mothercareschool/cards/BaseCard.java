package com.yf.fengmai.mothercareschool.cards;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.yf.fengmai.mothercareschool.beans.BaseBean;

/**
 * Created by fengmai on 2017/4/11.
 */

public abstract class BaseCard extends FrameLayout{
    protected View mContentView;
    protected Context mContext;
    public BaseCard(@NonNull Context context) {
        super(context);
        init(context);
    }

    public BaseCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        mContentView = inflate(context, getResId(), this);
        mContext = context;
        findViews();
    }
    protected abstract int  getResId();
    protected abstract void findViews();

    /**
     * 绑定数据 在各自的卡片中自己处理
     * @param baseBean
     */
    public abstract void bindData(BaseBean baseBean);

}
