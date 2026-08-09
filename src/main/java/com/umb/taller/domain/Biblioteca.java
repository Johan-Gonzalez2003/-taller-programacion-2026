package com.umb.taller.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Biblioteca {

    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public List<Libro> getLibros() {
        return Collections.unmodifiableList(libros);
    }

    public List<Usuario> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public List<Prestamo> getPrestamos() {
        return Collections.unmodifiableList(prestamos);
    }

    public void registrarLibro(Libro libro) {
        Objects.requireNonNull(libro, "El libro no puede ser nulo");
        if (!libros.contains(libro)) {
            libros.add(libro);
        }
    }

    public void registrarUsuario(Usuario usuario) {
        Objects.requireNonNull(usuario, "El usuario no puede ser nulo");
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    public Optional<Prestamo> realizarPrestamo(String documentoUsuario, String tituloLibro, LocalDate fechaPrestamo) {
        Objects.requireNonNull(documentoUsuario, "El documento de usuario no puede ser nulo");
        Objects.requireNonNull(tituloLibro, "El título del libro no puede ser nulo");
        Objects.requireNonNull(fechaPrestamo, "La fecha de préstamo no puede ser nula");

        Usuario usuario = buscarUsuarioPorDocumento(documentoUsuario);
        Libro libro = buscarLibroPorTitulo(tituloLibro);

        if (usuario == null || libro == null || !libro.isDisponible()) {
            return Optional.empty();
        }

        Prestamo prestamo = new Prestamo(usuario, libro, fechaPrestamo);
        prestamos.add(prestamo);
        return Optional.of(prestamo);
    }

    public Optional<Prestamo> buscarPrestamoActivo(String documentoUsuario, String tituloLibro) {
        return prestamos.stream()
                .filter(p -> p.getUsuario().getDocumento().equals(documentoUsuario))
                .filter(p -> p.getLibro().getTitulo().equals(tituloLibro))
                .filter(p -> !p.isDevuelto())
                .findFirst();
    }

    private Usuario buscarUsuarioPorDocumento(String documento) {
        return usuarios.stream()
                .filter(u -> u.getDocumento().equals(documento))
                .findFirst()
                .orElse(null);
    }

    private Libro buscarLibroPorTitulo(String titulo) {
        return libros.stream()
                .filter(l -> l.getTitulo().equals(titulo))
                .findFirst()
                .orElse(null);
    }

    public boolean registrarDevolucion(String documentoUsuario, String tituloLibro, LocalDate fechaDevolucion) {
        Optional<Prestamo> prestamoOpt = buscarPrestamoActivo(documentoUsuario, tituloLibro);
        if (prestamoOpt.isEmpty()) {
            return false;
        }

        Prestamo prestamo = prestamoOpt.get();
        return prestamo.registrarDevolucion(fechaDevolucion);
    }
}
