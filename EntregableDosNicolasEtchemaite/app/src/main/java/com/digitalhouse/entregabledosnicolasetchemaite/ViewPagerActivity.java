package com.digitalhouse.entregabledosnicolasetchemaite;

import android.app.Fragment;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewPagerActivity extends AppCompatActivity {

    public ViewPagerActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);


        transactionDoReplace(R.id.container_viewP,dameUnFragment(bundle));


    }

    public static FragmentDetalles dameUnFragment(Bundle bundle){
        FragmentDetalles fragmentDetalles = new FragmentDetalles();
        fragmentDetalles.setArguments(bundle);
        return fragmentDetalles;

    }
    private void transactionDoReplace(Integer container, android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
