package com.api_foro_hub.model.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
                                    @NotNull
                                    Long id,
                                    String titulo,
                                    String mensaje,
                                    String fecha) {
}
