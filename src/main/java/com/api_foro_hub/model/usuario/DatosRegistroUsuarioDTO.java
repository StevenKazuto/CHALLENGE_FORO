package com.api_foro_hub.model.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroUsuarioDTO(

        @NotBlank
        String nombre,

        @NotBlank
        @Email
        String correo,

        @NotBlank
        String nick,

        @NotBlank
        @Pattern(regexp = "\\d{6,10}")
        String contra) {


}
