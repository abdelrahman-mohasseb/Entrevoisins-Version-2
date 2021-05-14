package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListNeighbourActivity extends AppCompatActivity  {

    // UI Components
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.container)
    ViewPager mViewPager;

    ListNeighbourPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_neighbour);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mPagerAdapter = new ListNeighbourPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.AddFragment(NeighbourFragment.newInstance(), "My Neighbours");
        mPagerAdapter.AddFragment(FavoritFragment.newInstance(), "Favorits");
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }


    @OnClick(R.id.add_neighbour)
    void addNeighbour() {
        AddNeighbourActivity.navigate(this);
    }

}
