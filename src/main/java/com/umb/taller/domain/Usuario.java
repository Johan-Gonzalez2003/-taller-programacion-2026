package com.umb.taller.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Usuario {

    private String nombre;
    private String documento;
    private List<Libro> librosPrestados;

    public Usuario(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public List<Libro> getLibrosPrestados() {
        return Collections.unmodifiableList(librosPrestados);
    }

    public void agregarLibroPrestado(Libro libro) {
        if (libro != null) {
            librosPrestados.add(libro);
        }
    }

    public boolean retirarLibroPrestado(Libro libro) {
        if (libro == null) {
            return false;
        }

        return librosPrestados.remove(libro);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", librosPrestados=" + librosPrestados +
                '}';
    }
}