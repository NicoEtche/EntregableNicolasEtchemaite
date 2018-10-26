package com.digitalhouse.entregabledosnicolasetchemaite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPager extends FragmentStatePagerAdapter {

    private List<FragmentDetalles> fragmentDetallesList;


    public AdapterViewPager(FragmentManager fm, Integer positionStart) {
        super(fm);
        this.fragmentDetallesList = new ArrayList<>();
        List<Receta> recetaList = DAOReceta.crearRecetas();

        for (int i = positionStart; i < recetaList.size(); i++) {
            fragmentDetallesList.add(FragmentDetalles.fragmentDetallesFabric(recetaList.get(i)));

        }
        for (int j = 0; j <positionStart ; j++) {
            fragmentDetallesList.add(FragmentDetalles.fragmentDetallesFabric(recetaList.get(j)));

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
