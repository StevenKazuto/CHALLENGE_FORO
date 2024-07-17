package com.api_foro_hub.model.usuario;


import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
                                    @NotNull
                                    Long id,
                                    String nombre,
                                    String contra) {

}
