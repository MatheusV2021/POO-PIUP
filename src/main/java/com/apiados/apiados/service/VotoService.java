package com.apiados.apiados.service;

import com.apiados.apiados.model.Ideia;
import com.apiados.apiados.model.Usuario;
import com.apiados.apiados.model.Voto;
import com.apiados.apiados.repository.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final VotoRepository votoRepository;
    private final UsuarioService usuarioService;
    private final IdeiaService ideiaService;

    public Voto votar(Long usuarioId, Long ideiaId) {

        if (votoRepository.existsByUsuarioIdAndIdeiaId(usuarioId, ideiaId)) {
            throw new RuntimeException("Usuário já votou nesta ideia");
        }

        Usuario usuario = usuarioService.buscar(usuarioId);
        Ideia ideia = ideiaService.buscarPorId(ideiaId);

        Voto voto = new Voto();
        voto.setUsuario(usuario);
        voto.setIdeia(ideia);

        return votoRepository.save(voto);
    }

    public String contarVotos(Long ideiaId) {
        int quantidade = votoRepository.countByIdeiaId(ideiaId);
        return "Votos nessa ideia: " + quantidade;
    }

    public void removerVoto(Long votoId) {
        votoRepository.deleteById(votoId);
    }
}