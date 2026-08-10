package com.umb.taller.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements Repository<Libro, Long> {

    private final List<Libro> libros = new ArrayList<>();

    @Override
    public Libro save(Libro libro) {
        libros.add(libro);
        return libro;
    }

    @Override
    public Optional<Libro> findById(Long id) {
        return libros.stream()
                .filter(libro -> libro.getId() != null && libro.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Libro> findAll() {
        return new ArrayList<>(libros);
    }

    @Override
    public Libro update(Libro libro) {
        return libro;
    }

    @Override
    public void deleteById(Long id) {
        libros.removeIf(libro ->
                libro.getId() != null && libro.getId().equals(id)
        );
    }
}