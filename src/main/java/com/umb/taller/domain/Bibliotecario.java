package com.umb.taller.domain;

public class Bibliotecario extends Usuario {

    public Bibliotecario(String nombre, String documento) {
        super(nombre, documento);
    }

    @Override
    public String getTipoUsuario() {
        return "Bibliotecario";
    }
}
