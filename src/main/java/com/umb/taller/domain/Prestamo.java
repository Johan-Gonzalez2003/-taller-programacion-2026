package com.umb.taller.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Usuario usuario, Libro libro, LocalDate fechaPrestamo) {
        this.usuario = Objects.requireNonNull(usuario, "El usuario no puede ser nulo");
        this.libro = Objects.requireNonNull(libro, "El libro no puede ser nulo");
        this.fechaPrestamo = Objects.requireNonNull(fechaPrestamo, "La fecha de préstamo no puede ser nula");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public boolean isDevuelto() {
        return fechaDevolucion != null;
    }

    public boolean registrarDevolucion(LocalDate fechaDevolucion) {
        Objects.requireNonNull(fechaDevolucion, "La fecha de devolución no puede ser nula");

        if (isDevuelto()) {
            return false;
        }
        if (fechaDevolucion.isBefore(fechaPrestamo)) {
            return false;
        }

        boolean libroDevuelto = libro.devolver();
        if (!libroDevuelto) {
            return false;
        }

        this.fechaDevolucion = fechaDevolucion;
        return true;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "usuario=" + usuario +
                ", libro=" + libro +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
