package com.umb.taller.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioPolimorfismoTest {

    @Test
    void usuarioReferenciaUsaMetodoCorrectoSegunSubclase() {

        Usuario estudiante =
                new Estudiante("Ana", "123");

        Usuario bibliotecario =
                new Bibliotecario("Luis", "456");

        assertEquals(
                "Estudiante",
                estudiante.getTipoUsuario(),
                "La referencia Usuario debe invocar getTipoUsuario() de Estudiante"
        );

        assertEquals(
                "Bibliotecario",
                bibliotecario.getTipoUsuario(),
                "La referencia Usuario debe invocar getTipoUsuario() de Bibliotecario"
        );
    }
}