package com.api_foro_hub.model.topico;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha;
    private Boolean status;
    private String autor_nick;
    private String curso;

    public Topico(DatosRegistroTopicoTDO datosRegistroTopicoTDO) {
        this.status = true;
        this.titulo = datosRegistroTopicoTDO.titulo();
        this.mensaje = datosRegistroTopicoTDO.mensaje();
        this.fecha = datosRegistroTopicoTDO.fecha();
        this.autor_nick = datosRegistroTopicoTDO.autor_nick();
        this.curso = datosRegistroTopicoTDO.curso();

    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {

            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {

            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.fecha() != null) {

            this.fecha = datosActualizarTopico.fecha();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAutor_nick() {
        return autor_nick;
    }

    public void setAutor_nick(String autor_nick) {
        this.autor_nick = autor_nick;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fecha='" + fecha + '\'' +
                ", status=" + status +
                ", autor_nick='" + autor_nick + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
