package com.dicoding.picodiploma.jetpackdicoding.ui.home;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dicoding.picodiploma.jetpackdicoding.R;
import com.dicoding.picodiploma.jetpackdicoding.ui.movie.MovieFragment;
import com.dicoding.picodiploma.jetpackdicoding.ui.tv.TvFragment;


public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private final int[] TAB_TITLES = new int[]{R.string.tab_movie, R.string.tab_tv};
    private final Context mContext;

    public HomeViewPagerAdapter(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFragment();
            case 1:
                return new TvFragment();
            default:
                return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        //show 2 total pages.
        return 2;
    }
}
