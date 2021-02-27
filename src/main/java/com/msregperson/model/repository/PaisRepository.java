package com.msregperson.model.repository;

import com.msregperson.model.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaisRepository extends JpaRepository<Pais, UUID> {

    @Query("select p from Pais p where p.id = ?1")
    Pais findByPaisId(UUID id);

    @Query("select p from Pais p where p.nome = ?1")
    Pais findByPaisNome(String paisNome);

    @Query("select p from Pais p where p.sigla = ?1")
    Pais findByPaisSigla(String paisSigla);
}
