package com.apiados.apiados.service;

import com.apiados.apiados.model.MoradiaVulneravel;
import com.apiados.apiados.repository.MoradiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoradiaService {

    private final MoradiaRepository moradiaRepository;

    public MoradiaVulneravel salvar(MoradiaVulneravel m) {
        return moradiaRepository.save(m);
    }

    public List<MoradiaVulneravel> listar() {
        return moradiaRepository.findAll();
    }

    public MoradiaVulneravel buscar(Long id) {
        return moradiaRepository.findById(id).orElse(null);
    }
}
