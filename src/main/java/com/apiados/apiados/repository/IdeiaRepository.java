package com.apiados.apiados.repository;

import com.apiados.apiados.model.Ideia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeiaRepository extends JpaRepository<Ideia, Long> {
}
