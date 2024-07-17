package com.api_foro_hub.controller;

import com.api_foro_hub.model.usuario.DatosActualizarUsuario;
import com.api_foro_hub.model.usuario.DatosRegistroUsuarioDTO;
import com.api_foro_hub.model.usuario.PerfilAMostrar;
import com.api_foro_hub.model.usuario.Usuario;
import com.api_foro_hub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarUsuario(@RequestBody @Valid DatosRegistroUsuarioDTO parametrosRegistroUsuario) {
        System.out.println("El request llega correctamente");
        System.out.println(parametrosRegistroUsuario);

        usuarioRepository.save(new Usuario(parametrosRegistroUsuario));
    }

    @GetMapping("/mostrar")
//    public List<PerfilAMostrar> listadoUsuarios () {
                                                //spring jpa
    public Page<PerfilAMostrar> listadoUsuarios(Pageable paginacion) {
//        return usuarioRepository.findAll(paginacion)
        return usuarioRepository.findByActivoTrue(paginacion)
                .map(PerfilAMostrar::new);

//        return usuarioRepository.findAll().stream()
//                .map(PerfilAMostrar::new)
//                .collect(Collectors.toList());
    }

    @PutMapping("/actualizar")
    @Transactional //la transaccion se ejecuta, ya que no se esta usando el repositorio y se esta manejando con JPA puro
    public void actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario) {
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarDatoS(datosActualizarUsuario);
    }

    //DELETE lOGICO
    @DeleteMapping("/delete/{id}")
    @Transactional
    public void eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.desactivarUsuario();
    }

    //DELETE en la BD
//    public String  borrarUsuario(@PathVariable Long id) {
//        Usuario usuario = usuarioRepository.getReferenceById(id);
//        usuarioRepository.delete(usuario);
//        return "BORRADO";
//    }
}
