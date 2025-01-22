package com.example.crud_springboot.Respositorios;

import com.example.crud_springboot.Entidades.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepositorio extends JpaRepository<Prestamo, Integer> {
}
