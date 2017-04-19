package com.yf.fengmai.mothercareschool.beans;

import java.io.Serializable;

public class BaseBean implements Serializable {
    // 为第几条数据
    private int mItemNum;
    public int getItemNum() {
        return mItemNum;
    }
    public void setItemNum(int itemNum) {
        mItemNum = itemNum;
    }
}
