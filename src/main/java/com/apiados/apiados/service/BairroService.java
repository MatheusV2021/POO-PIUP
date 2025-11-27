package com.apiados.apiados.service;

import com.apiados.apiados.model.Bairro;
import com.apiados.apiados.repository.BairroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BairroService {

    private final BairroRepository bairroRepository;

    public Bairro salvar(Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    public List<Bairro> listar() {
        return bairroRepository.findAll();
    }
}