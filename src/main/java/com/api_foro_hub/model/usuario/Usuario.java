package com.api_foro_hub.model.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String nick;
    private String contra;
    private Boolean activo;

    public Usuario(DatosRegistroUsuarioDTO parametrosRegistroUsuario) {
        this.activo = true;
        this.nombre = parametrosRegistroUsuario.nombre();
        this.correo = parametrosRegistroUsuario.correo();
        this.nick = parametrosRegistroUsuario.nick();
        this.contra = parametrosRegistroUsuario.contra();
    }

    public void actualizarDatoS(DatosActualizarUsuario datosActualizarUsuario) {
        if (datosActualizarUsuario.nombre() != null) {
            this.nombre = datosActualizarUsuario.nombre();
        }
        if (datosActualizarUsuario.contra() != null) {
            this.contra = datosActualizarUsuario.contra();
        }
    }
    public void desactivarUsuario() {
        this.activo = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }



}
