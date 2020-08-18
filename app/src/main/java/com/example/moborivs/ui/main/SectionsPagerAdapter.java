package com.example.moborivs.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.moborivs.R;
import com.example.moborivs.fragments.Home;
import com.example.moborivs.fragments.MostRated;
import com.example.moborivs.fragments.Phones;
import com.example.moborivs.fragments.UpcomingPhone;
import com.example.moborivs.fragments.UsersReviews;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_Phones, R.string.tab_text_new, R.string.tab_text_best, R.string.tab_text_full};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
       Fragment fragment = null;
       switch (position){
           case 0:
               fragment = new Home();
               break;
           case 1:
               fragment = new UsersReviews();
               break;
           case 2:
               fragment = new Phones();
               break;
           case 3:
               fragment = new UpcomingPhone();
               break;
           case 4:
               fragment = new MostRated();
               break;
       }
       return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 5 total pages.
        return 5;
    }
}