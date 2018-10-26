package com.digitalhouse.entregabledosnicolasetchemaite;

import java.util.ArrayList;
import java.util.List;

public class DAOReceta {
    public static Receta crearRecetaHDC(){
        List<String> ingredientes = new ArrayList<>();
        ingredientes.add("Panceta");
        ingredientes.add("Carne de Cordero");
        ingredientes.add("Tomate");
        ingredientes.add("Salsa especial de la abuela Muriel");
        ingredientes.add("Pan hecho en casa");
        return new Receta("Hamburguesa de Cordero",R.drawable.hamburguesa_cordero, ingredientes,
                "Paty a fuego moderado, dejarlo reposar 5 minutos de cada lado. Poner los " +
                        "ingredientes como en cualquier hamburguesa y la salsa no te lo voy a decir.");
    }

    public static Receta crearRecetaHDA() {
        List<String> ingredientes = new ArrayList<>();
        ingredientes.add("Carne de Antilope");
        ingredientes.add("Huevo de Gallo");
        ingredientes.add("Queso de cabra");
        ingredientes.add("Mucho Ketchup");
        ingredientes.add("Huevo de Codorniz");
        ingredientes.add("Salsa Picante");

       return new Receta("Hamburguesa de Antilope", R.drawable.hamburguesa_antilope, ingredientes, "Carne cocinada con sal, dejarla reposar por 3 semanas." +
                "preparar el orden de los ingredientes a gusto y agregarle el huevo de codorniz crudo en el pan inferior");
    }

    public static Receta crearRecetaHA(){
        List<String> ingredientes = new ArrayList<>();
        ingredientes.add("Desconocido");

      return   new Receta("Hamburguesa Alienígena", R.drawable.hamburguesa_alien, ingredientes,"Hervir" +
                " el moco verde por 6 horas hasta que se haga azul y ponerselo al pan. Luego, aparecera tu hamburguesa.");

    }

    public static List<Receta> crearRecetas(){
        List<Receta> recetas = new ArrayList<>();
        recetas.add(crearRecetaHDA());
        recetas.add(crearRecetaHDC());
        recetas.add(crearRecetaHA());
        recetas.add(crearRecetaHDA());
        recetas.add(crearRecetaHDC());
        recetas.add(crearRecetaHA());
        recetas.add(crearRecetaHDA());
        recetas.add(crearRecetaHDC());
        recetas.add(crearRecetaHA());
        recetas.add(crearRecetaHDA());
        recetas.add(crearRecetaHDC());
        recetas.add(crearRecetaHA());
        recetas.add(crearRecetaHDA());
        recetas.add(crearRecetaHDC());
        recetas.add(crearRecetaHA());
        recetas.add(crearRecetaHDA());
        recetas.add(crearRecetaHDC());
        recetas.add(crearRecetaHA());
        recetas.add(crearRecetaHDA());
        recetas.add(crearRecetaHDC());
        recetas.add(crearRecetaHA());

        return recetas;
    }
}
