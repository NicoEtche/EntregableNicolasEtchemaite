package com.digitalhouse.entregabledosnicolasetchemaite;

import java.util.List;

public class Receta {

    private String titulo;
    private Integer foto;
    private List<String> ingredientes;
    private String preparacion;

    public Receta(String titulo, Integer foto, List<String> ingredientes, String preparacion) {
        this.titulo = titulo;
        this.foto = foto;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
    }

    public Integer getFoto() {
        return foto;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public String getTitulo() {
        return titulo;
    }
}
