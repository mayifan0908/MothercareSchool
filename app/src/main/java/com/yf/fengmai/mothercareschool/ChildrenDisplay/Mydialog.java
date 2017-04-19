package com.yf.fengmai.mothercareschool.ChildrenDisplay;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.WindowManager;

import com.yf.fengmai.mothercareschool.R;

/**
 * Created by fengmai on 2017/4/14.
 */

public class Mydialog extends Dialog{
    public Mydialog(@NonNull Context context) {
        super(context);
    }

    public Mydialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydialog);
    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity= Gravity.BOTTOM;
        layoutParams.width= WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height= WindowManager.LayoutParams.WRAP_CONTENT;

        getWindow().getDecorView().setPadding(5,5,5,5);

        getWindow().setAttributes(layoutParams);
    }
}
