package com.apiados.apiados.service;

import com.apiados.apiados.model.Usuario;
import com.apiados.apiados.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario criar(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario login(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getSenha().equals(password)) {
            throw new RuntimeException("Senha incorreta");
        }

        return usuario;
    }

    public Usuario atualizar(Long id, Usuario dados) {
        Usuario usuario = buscar(id);

        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());
        usuario.setSenha(dados.getSenha());
        usuario.setTipo(dados.getTipo());

        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        Usuario usuario = buscar(id);
        usuarioRepository.delete(usuario);
    }
}