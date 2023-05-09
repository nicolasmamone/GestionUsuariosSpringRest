package com.nico.gestionusuariosspringrest.service;

import com.nico.gestionusuariosspringrest.model.entities.Usuario;
import com.nico.gestionusuariosspringrest.model.repository.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    @Autowired
    private IUsuarioRepositorio repositorio;

    public List<Usuario> listarUsuarios(){
        return repositorio.findAll();
    }

    public void guardarUsuario(Usuario usuario){
        repositorio.save(usuario);
    }

    public Usuario obtenerUsuarioPorId(Integer id){
        return repositorio.findById(id).get();
    }

    public void eliminarUsuario(Integer id){
        repositorio.deleteById(id);
    }
}
