package com.example.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<String> usuarios = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<String>> getUsuarios() {
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody String usuario) {
        usuarios.add(usuario);
        return ResponseEntity.ok("Usuario creado: " + usuario);
    }

    @PutMapping("/{index}")
    public ResponseEntity<String> updateUsuario(@PathVariable int index, @RequestBody String usuario) {
        if (index < 0 || index >= usuarios.size()) {
            return ResponseEntity.badRequest().body("Índice no válido");
        }
        usuarios.set(index, usuario);
        return ResponseEntity.ok("Usuario actualizado: " + usuario);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int index) {
        if (index < 0 || index >= usuarios.size()) {
            return ResponseEntity.badRequest().body("Índice no válido");
        }
        String usuario = usuarios.remove(index);
        return ResponseEntity.ok("Usuario eliminado: " + usuario);
    }
}