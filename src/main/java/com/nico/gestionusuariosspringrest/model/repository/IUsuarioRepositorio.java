package com.nico.gestionusuariosspringrest.model.repository;

import com.nico.gestionusuariosspringrest.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer>  {

}
