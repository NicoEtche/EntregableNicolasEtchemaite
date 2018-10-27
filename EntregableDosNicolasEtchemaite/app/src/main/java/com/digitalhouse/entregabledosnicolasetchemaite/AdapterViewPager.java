package com.digitalhouse.entregabledosnicolasetchemaite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPager extends FragmentStatePagerAdapter {

    private List<FragmentDetalles> fragmentDetallesList;


    public AdapterViewPager(FragmentManager fm, List<Receta> recetas) {
        super(fm);
        this.fragmentDetallesList = new ArrayList<>();
        for (Receta receta:recetas) {
            fragmentDetallesList.add(FragmentDetalles.fragmentDetallesFabric(receta));
        }

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
