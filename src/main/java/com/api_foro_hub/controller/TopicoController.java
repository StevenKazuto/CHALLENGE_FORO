package com.api_foro_hub.controller;

import com.api_foro_hub.model.topico.DatosActualizarTopico;
import com.api_foro_hub.model.topico.DatosRegistroTopicoTDO;
import com.api_foro_hub.model.topico.Topico;
import com.api_foro_hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping("/registrar")
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopicoTDO datosRegistroTopicoTDO) {
        System.out.println("El request de TOPICO llega correctamente");
        System.out.println(datosRegistroTopicoTDO);
        topicoRepository.save(new Topico(datosRegistroTopicoTDO));
    }

    @GetMapping("/mostrar")
    public Page<Topico> listadoTopicos(Pageable paginacion) {
//        return topicoRepository.findAll(paginacion);
        return topicoRepository.findByStatusTrue(paginacion);
    }

    @GetMapping("/mostrar/{id}")
    public DatosRegistroTopicoTDO mostrarTopicoId(@PathVariable Long id) {
        Topico encotrado = topicoRepository.getReferenceById(id);
        return new DatosRegistroTopicoTDO(encotrado.getTitulo(), encotrado.getMensaje(), encotrado.getFecha(),
                encotrado.getStatus(), encotrado.getAutor_nick(),encotrado.getCurso());
    }

    @PutMapping("/actualizar")
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }


    //DELETE lOGICO
    @DeleteMapping("/eliminar/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }


}
