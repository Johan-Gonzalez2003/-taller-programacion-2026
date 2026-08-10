package com.umb.taller.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<Usuario, Long> {

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario save(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() != null && usuario.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuario;
    }

    @Override
    public void deleteById(Long id) {
        usuarios.removeIf(usuario ->
                usuario.getId() != null && usuario.getId().equals(id)
        );
    }
}