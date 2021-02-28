package com.msregperson.model.factory;

import com.msregperson.model.dto.*;
import com.msregperson.model.entity.Endereco;
import com.msregperson.model.entity.Pessoa;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PessoaDTOFactory {

    public Pessoa toPessoa(PessoaDTO dto){
        return Pessoa.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .endereco(new Endereco(UUID.fromString(dto.getIdEndereco())))
                .build();
    }

    public PessoaDTOResponse toPessoaDTO(Pessoa pessoa) {
        return PessoaDTOResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .cpf(pessoa.getCpf())
                .dataNascimento(pessoa.getDataNascimento())
                .endereco(EnderecoDTOResponse.builder()
                        .id(pessoa.getEndereco().getId())
                        .numero(pessoa.getEndereco().getNumero())
                        .cep(pessoa.getEndereco().getCep())
                        .logradouro(pessoa.getEndereco().getLogradouro())
                        .cidade(CidadeDTOResponse.builder()
                                .id(pessoa.getEndereco().getCidade().getId())
                                .nome(pessoa.getEndereco().getCidade().getNome())
                                .sigla(pessoa.getEndereco().getCidade().getSigla())
                                .build())
                        .estado(EstadoDTOResponse.builder()
                                .id(pessoa.getEndereco().getEstado().getId())
                                .nome(pessoa.getEndereco().getEstado().getNome())
                                .sigla(pessoa.getEndereco().getEstado().getSigla())
                                .build())
                        .pais(PaisDTOResponse.builder()
                                .id(pessoa.getEndereco().getPais().getId())
                                .nome(pessoa.getEndereco().getPais().getNome())
                                .sigla(pessoa.getEndereco().getPais().getSigla())
                                .build())
                        .build())
                .build();
    }
}
