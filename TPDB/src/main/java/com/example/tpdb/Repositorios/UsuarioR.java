package com.example.tpdb.Repositorios;

import com.example.tpdb.Entidades.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioR extends JpaRepository<Usuario, Long> {


}
