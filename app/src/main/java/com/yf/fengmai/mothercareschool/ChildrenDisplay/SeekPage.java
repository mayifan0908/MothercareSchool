package com.yf.fengmai.mothercareschool.ChildrenDisplay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.yf.fengmai.mothercareschool.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by fengmai on 2017/4/10.
 */

public class SeekPage extends Activity{
    private EditText ed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seeklayout);
        ed= (EditText) findViewById(R.id.ed);
        //调用软键盘
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }, 100);

    }


    public void onClick(View view){

        finish();
    }
}
