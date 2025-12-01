package com.apiados.apiados.service;

import com.apiados.apiados.model.Categoria;
import com.apiados.apiados.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscar(Long id) {
        return categoriaRepository.findById(id);
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
