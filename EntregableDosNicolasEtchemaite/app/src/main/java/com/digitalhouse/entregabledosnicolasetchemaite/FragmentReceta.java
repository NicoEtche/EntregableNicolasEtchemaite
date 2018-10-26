package com.digitalhouse.entregabledosnicolasetchemaite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentReceta extends Fragment {

private List<Receta> recetas;
    public FragmentReceta() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receta, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_recetas);
        recetas = DAOReceta.crearRecetas();
        AdapterRecetasRecyclerView adapterRecetasRecyclerView = new AdapterRecetasRecyclerView(recetas);
        recyclerView.setAdapter(adapterRecetasRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }
}
