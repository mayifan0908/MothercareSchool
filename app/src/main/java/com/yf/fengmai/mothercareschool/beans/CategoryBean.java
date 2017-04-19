package com.yf.fengmai.mothercareschool.beans;

public class CategoryBean extends BaseBean {
    private static final long serialVersionUID = 1L;



    // 内容名称
    private String cmake_tv = "";

    public String getCmake_tv() {
        return cmake_tv;
    }

    public void setCmake_tv(String cmake_tv) {
        this.cmake_tv = cmake_tv;
    }

    private int cmake_img;
    public int getCmake_img() {
        return cmake_img;
    }
    public void setCmake_img(int cmake_img) {
        this.cmake_img = cmake_img;
    }
}
