package com.digitalhouse.entregabledosnicolasetchemaite;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterRecetasRecyclerView.ListenerCeldaRV {
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.navigation_view_main);

        navigationView.setNavigationItemSelectedListener(new ListenerMenu());

        transactionDoReplace(R.id.container_main, new FragmentMain());


    }

    @Override
    public void celdaSeleccionada(Receta receta) {
        FragmentDetalles fragment = new FragmentDetalles();
        Bundle bundle = new Bundle();
        bundle.putString(fragment.CLAVE_TITLE, receta.getTitulo());
        bundle.putInt(fragment.CLAVE_FOTO, receta.getFoto());
        bundle.putStringArrayList(fragment.CLAVE_INGREDIENTES, (ArrayList<String>) receta.getIngredientes());
        bundle.putString(fragment.CLAVE_PREPARACION, receta.getPreparacion());
        fragment.setArguments(bundle);
        transactionDoReplace(R.id.container_main, fragment);

    }


    private void selectedMenuItem(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case (R.id.item_recetas_menu):
                transactionDoReplace(R.id.container_main, new FragmentReceta());
                break;
            case (R.id.item_about_us):
                transactionDoReplace(R.id.container_main, new FragmentAboutUs());
                break;
        }
    }


    private class ListenerMenu implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            selectedMenuItem(item);
            return true;
        }
    }

    private void transactionDoReplace(Integer container, android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
