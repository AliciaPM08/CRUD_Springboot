package com.example.crud_springboot.Respositorios;

import com.example.crud_springboot.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository <Usuario, Integer> {
}
