package com.msregperson.model.dto;

import com.msregperson.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private String nome;
    private String cpf;
    private String dataNascimento;
    private Endereco endereco;
}
