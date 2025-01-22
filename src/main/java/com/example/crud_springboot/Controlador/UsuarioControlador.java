package com.example.crud_springboot.Controlador;


import com.example.crud_springboot.Entidades.Usuario;
import com.example.crud_springboot.Respositorios.UsuarioRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioControlador(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    //SELECT *
    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> lista= this.usuarioRepositorio.findAll();
        System.out.println(lista);
        return ResponseEntity.ok(lista);
    }

    //SELECT BY ID
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Integer id) {
        Usuario u = this.usuarioRepositorio.findById(id).get();
        return ResponseEntity.ok(u);
    }

    //INSERT
    @PostMapping("/usuario")
    public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioPersistido = this.usuarioRepositorio.save(usuario);
        return ResponseEntity.ok().body(usuarioPersistido);
    }

    //POST con Form normal
    @PostMapping(value = "/usuarioForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Usuario> addUsuarioForm(@RequestParam String dni,
                                                  @RequestParam String nombre,
                                                  @RequestParam String email,
                                                  @RequestParam String password,
                                                  @RequestParam String tipo) {



            Usuario usuario = new Usuario();
            usuario.setDni(dni);
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setTipo(tipo);

            this.usuarioRepositorio.save(usuario);
            return ResponseEntity.created(null).body(usuario);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable Integer id) {
        Usuario usuarioPersistido = usuarioRepositorio.save(usuario);
        return ResponseEntity.ok().body(usuarioPersistido);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Integer id) {
        usuarioRepositorio.deleteById(id);
        String mensaje = "Usuario borrado";
        return ResponseEntity.ok().body(mensaje);
    }
}
