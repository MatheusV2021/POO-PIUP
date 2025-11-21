package com.apiados.apiados.service;

import com.apiados.apiados.model.Ideia;
import com.apiados.apiados.repository.IdeiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IdeiaService {

    private final IdeiaRepository ideiaRepository;

    public Ideia criar(Ideia ideia) {
        ideia.setStatus("Recebida");
        ideia.setPrioridade(0);
        return ideiaRepository.save(ideia);
    }

    public List<Ideia> listar() {
        return ideiaRepository.findAll();
    }

    public Ideia buscarPorId(Long id) {
        return ideiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ideia não encontrada"));
    }

    public Ideia atualizarStatus(Long id, String status) {
        Ideia ideia = buscarPorId(id);
        ideia.setStatus(status);
        return ideiaRepository.save(ideia);
    }

    public Ideia editar(Long id, Ideia dadosNovos) {
        Ideia ideia = buscarPorId(id);

        ideia.setTitulo(dadosNovos.getTitulo());
        ideia.setDescricao(dadosNovos.getDescricao());
        ideia.setCategoria(dadosNovos.getCategoria());
        ideia.setLocalizacao(dadosNovos.getLocalizacao());
        ideia.setPrioridade(dadosNovos.getPrioridade());
        ideia.setFoto(dadosNovos.getFoto());

        return ideiaRepository.save(ideia);
    }

    public void deletar(Long id) {
        Ideia ideia = buscarPorId(id);
        ideiaRepository.delete(ideia);
    }
}