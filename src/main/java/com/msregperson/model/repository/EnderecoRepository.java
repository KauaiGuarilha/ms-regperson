package com.msregperson.model.repository;

import com.msregperson.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, UUID> {}
