package com.msregperson.model.repository;

import com.msregperson.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

    @Query("select p from Pessoa p where p.cpf = ?1")
    Pessoa findByPessoaCpf(String cpf);
}
