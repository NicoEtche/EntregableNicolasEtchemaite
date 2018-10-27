package com.digitalhouse.entregabledosnicolasetchemaite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentReceta extends Fragment {
    protected static EditText editText;
private List<Receta> recetas;
    public FragmentReceta() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receta, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.recycler_view_recetas);
        recetas = DAOReceta.crearRecetas();
        editText = view.findViewById(R.id.edit_text);
        AdapterRecetasRecyclerView adapterRecetasRecyclerView = new AdapterRecetasRecyclerView(recetas);
        recyclerView.setAdapter(adapterRecetasRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               /* ListenerBusqueda listenerBusqueda = (ListenerBusqueda) getContext();
                listenerBusqueda.busqueda();*/
                AdapterRecetasRecyclerView adapterRecetasRecyclerView =
                        new AdapterRecetasRecyclerView(filtrarBusqueda(editText.getText()));

                recyclerView.setAdapter(adapterRecetasRecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });

        return view;
    }

    public List<Receta> filtrarBusqueda(CharSequence string) {
        List<Receta> filtroRecetas = new ArrayList<>();
        for (Receta receta : recetas) {
            if (receta.getTitulo().toLowerCase().contains(string)) {
                filtroRecetas.add(receta);
            }

            }

        if (filtroRecetas.equals(null)) {
            return recetas;
        } else {
            return filtroRecetas;
        }
    }

    public EditText getEditText() {
        return editText;
    }
}
