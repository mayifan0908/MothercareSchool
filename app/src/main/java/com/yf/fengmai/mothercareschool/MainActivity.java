package com.yf.fengmai.mothercareschool;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.yf.fengmai.mothercareschool.ChildrenDisplay.Mydialog;
import com.yf.fengmai.mothercareschool.ChildrenDisplay.SeekPage;
import com.yf.fengmai.mothercareschool.fragments.BBSListFragment;
import com.yf.fengmai.mothercareschool.fragments.MainListFragment;
import com.yf.fengmai.mothercareschool.recyclerview.QQRefreshHeader;
import com.yf.fengmai.mothercareschool.recyclerview.RefreshLayout;

import java.util.ArrayList;

import static com.yf.fengmai.mothercareschool.R.id.rb_1;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private TabHost tabhost;
    private RollPagerView rollPV = null;
    private RecyclerView hrv,vrv;
    private ArrayList<Integer> imgs;
    private HrvAdapter hadapter;
    private RadioGroup rg;
    private RadioButton[] rbArray;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments ;
    private int current;
    private RefreshLayout mainrefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        mainrefreshLayout= (RefreshLayout) findViewById(R.id.main_refreshLayout);
        initview();
        initrecycler();
        initrg();
        initfragment();
    }

    private void initfragment() {
        FragmentTransaction ft = fm.beginTransaction();
        BBSListFragment fm1=BBSListFragment.newinstance();
        MainListFragment fm2=MainListFragment.newinstance();
        fragments.add(fm1);
        fragments.add(fm2);
        ft.add(R.id.rg_frame, fragments.get(0)).commit();

    }

    private void initrg() {
        fm =getSupportFragmentManager();
        fragments = new ArrayList<Fragment>();
        rg = (RadioGroup)findViewById(R.id.rg);
        rbArray = new RadioButton[rg.getChildCount()];
        for (int i = 0; i < rg.getChildCount(); i++) {
            rbArray[i] = (RadioButton) rg.getChildAt(i);
        }
        rbArray[0].setChecked(true);
        rg.setOnCheckedChangeListener(this);
    }

    private void initrecycler() {
        imgs=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            imgs.add(R.drawable.hrvitemimg1);
        }
        hrv= (RecyclerView) findViewById(R.id.hrv);
        LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
        hadapter=new HrvAdapter(imgs,MainActivity.this);
        hrv.setLayoutManager(manager);
        hrv.setAdapter(hadapter);
//vrv
        ArrayList<Integer> vimgs=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vimgs.add(R.drawable.vrvitemimg1);
        }
        vrv= (RecyclerView) findViewById(R.id.vrv);
        LinearLayoutManager vmanager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        VrvAdapter vadapter=new VrvAdapter(vimgs,MainActivity.this);
        vrv.setAdapter(vadapter);
        vrv.setLayoutManager(vmanager);

    }

    private void initview() {
        if (mainrefreshLayout!=null){
            mainrefreshLayout.setRefreshListener(new RefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    mainrefreshLayout.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mainrefreshLayout.refreshComplete();

                        }
                    },1000);
                }
            });
        }
        QQRefreshHeader header  = new QQRefreshHeader(MainActivity.this);
        mainrefreshLayout.setRefreshHeader(header);
        mainrefreshLayout.autoRefresh();
        View view1= LayoutInflater.from(MainActivity.this).inflate(R.layout.tabhostitem1,null);
        View view2= LayoutInflater.from(MainActivity.this).inflate(R.layout.tabhostitem2,null);
        View view3= LayoutInflater.from(MainActivity.this).inflate(R.layout.tabhostitem3,null);
        View view4= LayoutInflater.from(MainActivity.this).inflate(R.layout.tabhostitem3,null);
        tabhost= (TabHost) findViewById(R.id.tabhost);
        tabhost.setup();
        tabhost.addTab(tabhost
                .newTabSpec("tag1")
                .setIndicator(view1)
                .setContent(R.id.layout1));
        tabhost.addTab(tabhost
                .newTabSpec("tag2")
                .setIndicator(view2)
                .setContent(R.id.layout2));
        tabhost.addTab(tabhost
                .newTabSpec("tag3")
                .setIndicator(view3)
                .setContent(R.id.layout3));


        rollPV = (RollPagerView) findViewById(R.id.mrollview);
        rollPV.setPlayDelay(3000);
        rollPV.setAnimationDurtion(500);
        //设置指示器:
        //rollPV.setHintView(new IconHintView());
        //rollPV.setHintView(new IconHintView(this,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        rollPV.setHintView(new ColorPointHintView(this,
                Color.parseColor("#FF0080"),
                Color.parseColor("#8E888A")));
        //设置适配器
        rollPV.setAdapter(new RollPagerAdapter());

//        rollPV.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                Toast.makeText(MainActivity.this, "点击了图片"+position, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private int images[] = {
           R.drawable.image_podcast_tooltip,
            R.drawable.image_login_prompt,
            R.drawable.image_podcast_tooltip,
            R.drawable.image_login_prompt,
    };

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case rb_1:
                Log.e("myf","rb_1");
                showFragment(rb_1);
                break;

            case R.id.rb_2:
                Log.e("myf","rb_2");
                showFragment(R.id.rb_2);
                break;

            default:
                break;
        }
    }

    //适配器
    private class RollPagerAdapter extends StaticPagerAdapter {

        @Override
        public View getView(ViewGroup container, int position) {

            ImageView view=new ImageView(container.getContext());
            //设置图片资源
            view.setImageResource(images[position]);
            //设置高度和宽度
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //设置拉伸方式
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);

            return view;
        }
        @Override
        public int getCount() {
            return images.length;
        }
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ss:
                Intent intent=new Intent(MainActivity.this, SeekPage.class);
                startActivity(intent);
//                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                //得到InputMethodManager的实例
//                if (imm.isActive()) {
//                    // 如果开启
//                    imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
//                            InputMethodManager.HIDE_NOT_ALWAYS);
//                    // 关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
//                }
                break;
            case R.id.bj:
                showdialog();
                break;
        }
    }
    private void showdialog() {
        Dialog dialog=new Mydialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
    }
    private void showFragment(int id) {
        FragmentTransaction ft = fm.beginTransaction();
        for (int i = 0; i < rg.getChildCount(); i++) {
            if (rbArray[i].getId() == id) {
                if (fragments.get(i).isAdded()) {
                    ft.show(fragments.get(i)).hide(fragments.get(current)).commit();
                } else {
                    ft.add(R.id.rg_frame, fragments.get(i)).hide(fragments.get(current)).commit();
                }
                current = i;
            }
        }


    }

}
