package com.umb.taller.domain;

public class Estudiante extends Usuario {

    public Estudiante(String nombre, String documento) {
        super(nombre, documento);
    }

    @Override
    public String getTipoUsuario() {
        return "Estudiante";
    }
}
