package com.apiados.apiados.controller;

import com.apiados.apiados.model.Bairro;
import com.apiados.apiados.service.BairroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bairros")
@RequiredArgsConstructor
public class BairroController {

    private final BairroService bairroService;

    @PostMapping
    public Bairro criar(@RequestBody Bairro bairro) {
        return bairroService.salvar(bairro);
    }

    @GetMapping
    public List<Bairro> listar() {
        return bairroService.listar();
    }
}