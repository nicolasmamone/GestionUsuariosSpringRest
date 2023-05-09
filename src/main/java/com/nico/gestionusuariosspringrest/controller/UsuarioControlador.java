package com.nico.gestionusuariosspringrest.controller;

import com.nico.gestionusuariosspringrest.model.entities.Usuario;
import com.nico.gestionusuariosspringrest.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio servicio;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios(){
        return servicio.listarUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id){
        try{
            Usuario usuario = servicio.obtenerUsuarioPorId(id);
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/usuarios")
    public void guardarUsuario(@RequestBody Usuario usuario){
        servicio.guardarUsuario(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario, @PathVariable Integer id){
        try {
            Usuario usuarioActual = servicio.obtenerUsuarioPorId(id);
            usuarioActual.setNombre(usuario.getNombre());
            usuarioActual.setApellido(usuario.getApellido());
            servicio.guardarUsuario(usuarioActual);
            return new ResponseEntity<Usuario>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("usuarios/{id}")
    public void eliminarUsuario(@PathVariable Integer id){
        servicio.eliminarUsuario(id);
    }


}
