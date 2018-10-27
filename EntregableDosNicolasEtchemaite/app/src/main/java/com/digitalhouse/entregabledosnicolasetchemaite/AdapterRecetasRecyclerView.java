package com.digitalhouse.entregabledosnicolasetchemaite;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterRecetasRecyclerView extends RecyclerView.Adapter<AdapterRecetasRecyclerView.RecetaViewHolder> {
    public static Integer position;
    private List<Receta> recetas;

   public AdapterRecetasRecyclerView(List<Receta> recetas) {
      this.recetas = recetas;
   }

   @NonNull
   @Override
   public RecetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater inflador = LayoutInflater.from(parent.getContext());

      View viewDelaCelda = inflador.inflate(R.layout.celda_recetas, parent, false);

      RecetaViewHolder recetaViewHolder = new RecetaViewHolder(viewDelaCelda);


      return recetaViewHolder;
   }

   @Override
   public void onBindViewHolder(@NonNull RecetaViewHolder holder, int position) {
      holder.bindReceta(recetas.get(position));

   }

   @Override
   public int getItemCount() {
      return recetas.size();
   }

   public class RecetaViewHolder extends RecyclerView.ViewHolder {
      private ImageView imagenReceta;
      private TextView titulo;
      private LinearLayout celda;
      private EditText busqueda;

      public RecetaViewHolder(View itemView) {
         super(itemView);
         imagenReceta = itemView.findViewById(R.id.imagen_receta_rv);
         titulo = itemView.findViewById(R.id.titulo_receta_rv);
         celda = itemView.findViewById(R.id.celda_recycler_view);

         celda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ListenerCeldaRV listenerCeldaRV = (ListenerCeldaRV) v.getContext();
               Receta receta = recetas.get(getAdapterPosition());
               position = getAdapterPosition();
               listenerCeldaRV.celdaSeleccionada(receta);


            }
         });
      }


      public void bindReceta(Receta receta){
         imagenReceta.setImageResource(receta.getFoto());
         titulo.setText(receta.getTitulo());

      }


   }
   public interface ListenerCeldaRV {
      public void celdaSeleccionada(Receta re);
   }

   public void setRecetas(List<Receta> recetas) {
      this.recetas = recetas;
   }
}



