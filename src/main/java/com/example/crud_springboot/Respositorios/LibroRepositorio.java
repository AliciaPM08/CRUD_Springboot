package com.example.crud_springboot.Respositorios;

import com.example.crud_springboot.Entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, String> {
}
