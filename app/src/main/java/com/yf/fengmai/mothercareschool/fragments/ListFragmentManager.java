package com.yf.fengmai.mothercareschool.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by fengmai on 2017/4/11.
 */

public class ListFragmentManager {
    public static void addFragment(FragmentManager fragmentManager,
                                   Fragment fragment,
                                   int fragmentID){

        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(fragmentID,fragment);
        transaction.commit();
    }
    public static void removeFragment(FragmentManager fragmentManager,
                                      Fragment fragment){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }
}
