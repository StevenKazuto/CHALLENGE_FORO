package com.api_foro_hub.model.usuario;

public record PerfilAMostrar(
        Long id,
        String nick) {


    public PerfilAMostrar(Usuario usuario) {
        this(usuario.getId(),
                usuario.getNick());
    }

}
