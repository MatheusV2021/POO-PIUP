package com.apiados.apiados.controller;

import com.apiados.apiados.model.MoradiaVulneravel;
import com.apiados.apiados.service.MoradiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moradias")
@RequiredArgsConstructor
public class MoradiaController {

    private final MoradiaService moradiaService;

    @PostMapping
    public MoradiaVulneravel criar(@RequestBody MoradiaVulneravel m) {
        return moradiaService.salvar(m);
    }

    @GetMapping
    public List<MoradiaVulneravel> listar() {
        return moradiaService.listar();
    }

    @GetMapping("/{id}")
    public MoradiaVulneravel buscar(@PathVariable Long id) {
        return moradiaService.buscar(id);
    }
}
