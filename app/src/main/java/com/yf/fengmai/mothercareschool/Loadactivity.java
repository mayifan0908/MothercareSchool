package com.yf.fengmai.mothercareschool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by fengmai on 2017/4/7.
 */

public class Loadactivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadactivity);

        initintent();
    }

    private void initintent() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(Loadactivity.this,MainActivity.class);
                startActivity(intent);
                Loadactivity.this.finish();

            }
        }.start();
    }
}
