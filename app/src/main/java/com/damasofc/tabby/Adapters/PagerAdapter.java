package com.damasofc.tabby.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.damasofc.tabby.Fragments.CountriesFragment;
import com.damasofc.tabby.Fragments.PersonFragment;

/**
 * Created by damasofc on 11-16-17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numTabs;

    public PagerAdapter(FragmentManager fm, int numTabs){
        super(fm);
        this.numTabs = numTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch	(position)	{
            case	0:
                //devolvemos	una	nueva	instancia	de	el	primer	fragment(que	tenemos	creado)
                return	new CountriesFragment();
            case	1:
                //devolvemos	una	nueva	instancia	de	el	segundo	fragment(que	tenemos	creado)
                return	new PersonFragment();
            default:
                return	null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
