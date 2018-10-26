package com.digitalhouse.entregabledosnicolasetchemaite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalles extends Fragment {

    public static final String CLAVE_TITLE = "TITULO";
    public static final String CLAVE_FOTO = "foto";
    public static final String CLAVE_INGREDIENTES = "13423";
    public static final String CLAVE_PREPARACION = "asdag";


    public FragmentDetalles() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalles, container, false);
        Bundle bundle = getArguments();
        ImageView foto = view.findViewById(R.id.image_detalle);
        TextView title = view.findViewById(R.id.text_view_title_detalle);
        TextView preparacion = view.findViewById(R.id.text_view_preparacion);
        TextView ingredientes = view.findViewById(R.id.text_view_ingredientes);
        foto.setImageResource(bundle.getInt(CLAVE_FOTO));
        title.setText(bundle.getString(CLAVE_TITLE));
        ingredientes.setText(bundle.getStringArrayList(CLAVE_INGREDIENTES).toString());
        preparacion.setText(bundle.getString(CLAVE_PREPARACION));
        
        return view;
    }
public static FragmentDetalles fragmentDetallesFabric (Receta receta){
        FragmentDetalles fragmentDetalles = new FragmentDetalles();
        Bundle bundle = new Bundle();
    bundle.putString(FragmentDetalles.CLAVE_TITLE, receta.getTitulo());
    bundle.putInt(FragmentDetalles.CLAVE_FOTO, receta.getFoto());
    bundle.putStringArrayList(FragmentDetalles.CLAVE_INGREDIENTES, (ArrayList<String>) receta.getIngredientes());
    bundle.putString(FragmentDetalles.CLAVE_PREPARACION, receta.getPreparacion());
    fragmentDetalles.setArguments(bundle);
        return fragmentDetalles;
}


}
