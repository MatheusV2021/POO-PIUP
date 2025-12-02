package com.apiados.apiados.service;

import com.apiados.apiados.model.Comentario;
import com.apiados.apiados.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario criar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarTodos() {
        return comentarioRepository.findAll();
    }

    public Comentario buscarPorId(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    public Comentario atualizar(Long id, Comentario novo) {
        Comentario existente = buscarPorId(id);

        existente.setAutor(novo.getAutor());
        existente.setMensagem(novo.getMensagem());

        return comentarioRepository.save(existente);
    }

    public void deletar(Long id) {
        comentarioRepository.deleteById(id);
    }
}
