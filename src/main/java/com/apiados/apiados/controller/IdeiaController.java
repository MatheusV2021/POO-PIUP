package com.apiados.apiados.controller;

import com.apiados.apiados.model.Ideia;
import com.apiados.apiados.service.IdeiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ideias")
@RequiredArgsConstructor
public class IdeiaController {

    private final IdeiaService ideiaService;

    @PostMapping
    public ResponseEntity<Ideia> criar(@RequestBody Ideia ideia) {
        return ResponseEntity.ok(ideiaService.criar(ideia));
    }

    @GetMapping
    public ResponseEntity<List<Ideia>> listar() {
        return ResponseEntity.ok(ideiaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ideia> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(ideiaService.buscarPorId(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Ideia> atualizarStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(ideiaService.atualizarStatus(id, status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ideia> editar(
            @PathVariable Long id,
            @RequestBody Ideia ideia) {

        return ResponseEntity.ok(ideiaService.editar(id, ideia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ideiaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
