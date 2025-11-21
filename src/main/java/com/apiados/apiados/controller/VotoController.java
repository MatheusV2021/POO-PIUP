package com.apiados.apiados.controller;

import com.apiados.apiados.model.Voto;
import com.apiados.apiados.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votos")
@RequiredArgsConstructor
public class VotoController {

    private final VotoService votoService;

    @PostMapping
    public ResponseEntity<Voto> votar(
            @RequestParam Long usuarioId,
            @RequestParam Long ideiaId) {

        return ResponseEntity.ok(votoService.votar(usuarioId, ideiaId));
    }

    @GetMapping("/ideia/{ideiaId}")
    public ResponseEntity<String> contar(@PathVariable Long ideiaId) {
        return ResponseEntity.ok(votoService.contarVotos(ideiaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        votoService.removerVoto(id);
        return ResponseEntity.noContent().build();
    }
}
