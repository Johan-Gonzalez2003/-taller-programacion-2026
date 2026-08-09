package com.umb.taller.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibroTest {

    @Test
    void libroComienzaDisponibleYSeActualizaAlPrestarYDevolver() {

        Libro libro = new Libro(
                "Cien años de soledad",
                "Gabriel García Márquez"
        );

        assertTrue(
                libro.isDisponible(),
                "El libro debe comenzar disponible"
        );

        boolean prestado = libro.prestar();

        assertTrue(
                prestado,
                "El préstamo debe ser exitoso cuando el libro está disponible"
        );

        assertFalse(
                libro.isDisponible(),
                "El libro no debe estar disponible después de prestarlo"
        );

        boolean devuelto = libro.devolver();

        assertTrue(
                devuelto,
                "La devolución debe ser exitosa cuando el libro estaba prestado"
        );

        assertTrue(
                libro.isDisponible(),
                "El libro debe volver a estar disponible después de devolverlo"
        );
    }
}