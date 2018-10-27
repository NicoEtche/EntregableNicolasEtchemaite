package com.digitalhouse.entregabledosnicolasetchemaite;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    public ViewPagerActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new AdapterViewPager(getSupportFragmentManager(),   filtrarBusqueda(bundle.getCharSequence("edit"))));
        viewPager.setCurrentItem(bundle.getInt("position"));


    }
    public List<Receta> filtrarBusqueda(CharSequence string) {
        List<Receta> filtroRecetas = new ArrayList<>();
        List<Receta> recetas = DAOReceta.crearRecetas();
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

}
