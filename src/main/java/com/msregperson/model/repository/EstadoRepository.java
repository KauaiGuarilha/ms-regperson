package com.msregperson.model.repository;

import com.msregperson.model.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, UUID> {

    @Query("select e from Estado e where e.id = ?1")
    Estado findByEstadoId(UUID id);

    @Query("select e from Estado e where e.nome = ?1")
    Estado findByEstadoNome(String estadoNome);

    @Query("select e from Estado e where e.sigla = ?1")
    Estado findByEstadoSigla(String estadoSigla);
}
