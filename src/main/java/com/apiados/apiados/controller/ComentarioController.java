package com.apiados.apiados.controller;

import com.apiados.apiados.model.Comentario;
import com.apiados.apiados.service.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<Comentario> criar(@RequestBody Comentario comentario) {
        return ResponseEntity.ok(comentarioService.criar(comentario));
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> listar() {
        return ResponseEntity.ok(comentarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(comentarioService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> atualizar(
            @PathVariable Long id,
            @RequestBody Comentario comentario) {
        return ResponseEntity.ok(comentarioService.atualizar(id, comentario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        comentarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
