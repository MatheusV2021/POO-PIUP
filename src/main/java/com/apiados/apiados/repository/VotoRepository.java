package com.apiados.apiados.repository;

import com.apiados.apiados.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VotoRepository extends JpaRepository<Voto, Long> {

    boolean existsByUsuarioIdAndIdeiaId(Long usuarioId, Long ideiaId);

    int countByIdeiaId(Long ideiaId);

    @Query("SELECT COUNT(v) FROM Voto v WHERE v.ideia.id = :ideiaId")
    long contarVotosPorIdeia(Long ideiaId);
}