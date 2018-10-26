package com.digitalhouse.entregabledosnicolasetchemaite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class AdapterViewPager extends FragmentStatePagerAdapter {

    private List<FragmentDetalles> fragmentDetallesList;


    public AdapterViewPager(FragmentManager fm, List<FragmentDetalles> fragmentDetallesList) {
        super(fm);
        this.fragmentDetallesList = fragmentDetallesList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentDetallesList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentDetallesList.size();
    }
}
