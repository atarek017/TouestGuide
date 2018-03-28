package com.example.ahmed150236.touestguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ahmed150236 on 05-Feb-18.
 */

public class cuntryFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public cuntryFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0)
            return new CairoFragment();
        else if (position == 1)
            return new LuxorFragment();
        else if (position == 2)
            return new AlexandriaFragment();
        else
            return new GizakFragment();

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.cairo_catogry);
        } else if (position == 1) {
            return mContext.getString(R.string.luxor_catogry);
        } else if (position == 2) {
            return mContext.getString(R.string.alex_catogry);
        } else {
            return mContext.getString(R.string.giza_catogry);
        }
    }
}
