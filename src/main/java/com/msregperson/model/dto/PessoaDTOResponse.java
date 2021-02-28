package com.msregperson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTOResponse {

    private UUID id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private EnderecoDTOResponse endereco;
}
