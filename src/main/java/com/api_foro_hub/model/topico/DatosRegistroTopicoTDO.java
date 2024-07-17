package com.api_foro_hub.model.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopicoTDO(

        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String fecha,

        @NotNull
        Boolean status,

        @NotBlank
        String autor_nick,

        @NotBlank
        String curso) {

}
