package com.digitalhouse.entregabledosnicolasetchemaite;


import android.content.Intent;
import android.os.Parcelable;
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

        navigationView = findViewById(R.id.navigation_view_main);

        navigationView.setNavigationItemSelectedListener(new ListenerMenu());

        transactionDoReplace(R.id.container_main, new FragmentMain());


    }

    @Override
    public void celdaSeleccionada(Receta receta) {
        //FragmentDetalles fragment = new FragmentDetalles();
        Bundle bundle = new Bundle();
        Integer position = AdapterRecetasRecyclerView.position;
        bundle.putInt("position", position);
        Intent intent = new Intent(this, ViewPagerActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);



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
