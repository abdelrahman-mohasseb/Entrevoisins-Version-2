package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;
import java.util.List;


public class  ListNeighbourPagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> listFragments = new ArrayList<>();
    private final List<String> listTitles = new ArrayList<>();

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);

    }

    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return listTitles.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
       return listTitles.get(position);
    }

    public void AddFragment (Fragment fragment, String title){

        listFragments.add(fragment);
        listTitles.add(title);
    }
}


