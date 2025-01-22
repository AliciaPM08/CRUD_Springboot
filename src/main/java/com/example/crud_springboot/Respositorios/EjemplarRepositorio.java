package com.example.crud_springboot.Respositorios;

import com.example.crud_springboot.Entidades.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjemplarRepositorio extends JpaRepository<Ejemplar, Integer> {
}
