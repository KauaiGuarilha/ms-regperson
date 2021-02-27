package com.msregperson.model.repository;

import com.msregperson.model.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, UUID> {

    @Query("select c from Cidade c where c.id = ?1")
    Cidade findByCidadeId(UUID id);

    @Query("select c from Cidade c where c.nome = ?1")
    Cidade findByCidadeNome(String cidadeNome);

    @Query("select c from Cidade c where c.sigla = ?1")
    Cidade findByCidadeSigla(String cidadeSigla);
}
