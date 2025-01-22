package com.example.crud_springboot.Controlador;


import com.example.crud_springboot.Entidades.Prestamo;
import com.example.crud_springboot.Respositorios.PrestamoRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamosControlador {
    private final PrestamoRepositorio prestamoRepositorio;

    @Autowired
    public PrestamosControlador(PrestamoRepositorio prestamoRepository) {
        this.prestamoRepositorio = prestamoRepository;
    }

    //SELECT *
    @GetMapping
    public ResponseEntity<List<Prestamo>> getPrestamos() {
        List<Prestamo> lista = prestamoRepositorio.findAll();
        System.out.println(lista);
        return ResponseEntity.ok(lista);
    }

    //SELECT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Integer id) {
        Prestamo p= this.prestamoRepositorio.findById(id).get();
        return ResponseEntity.ok(p);
    }

    //INSERT
    @PostMapping
    public ResponseEntity<Prestamo> addPrestamo(@Valid @RequestBody Prestamo prestamo) {
        Prestamo prestamoPersistido = this.prestamoRepositorio.save(prestamo);
        return ResponseEntity.ok().body(prestamoPersistido);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@Valid @RequestBody Prestamo prestamo, @PathVariable Integer id) {
        Prestamo prestamOPersistido= prestamoRepositorio.save(prestamo);
        return ResponseEntity.ok().body(prestamOPersistido);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrestamo(@PathVariable Integer id) {
        prestamoRepositorio.deleteById(id);
        return ResponseEntity.ok().body("Prestamo eliminado");
    }


}
