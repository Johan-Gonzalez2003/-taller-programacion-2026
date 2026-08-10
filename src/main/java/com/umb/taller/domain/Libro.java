package com.umb.taller.domain;

public class Libro {

    private Long id;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(Long id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public Libro(String titulo, String autor) {
        this(null, titulo, autor);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public boolean prestar() {
        if (!disponible) {
            return false;
        }

        disponible = false;
        return true;
    }

    public boolean devolver() {
        if (disponible) {
            return false;
        }

        disponible = true;
        return true;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}