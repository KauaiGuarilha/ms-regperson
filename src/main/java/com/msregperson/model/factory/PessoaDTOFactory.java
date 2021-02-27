package com.msregperson.model.factory;

import com.msregperson.model.dto.EnderecoDTO;
import com.msregperson.model.dto.PessoaDTO;
import com.msregperson.model.dto.PessoaDTOResponse;
import com.msregperson.model.entity.Pessoa;
import org.springframework.stereotype.Component;

@Component
public class PessoaDTOFactory {

    public Pessoa toPessoa(PessoaDTO dto){
        return Pessoa.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .dataNascimento(dto.getDataNascimento())
                .endereco(dto.getEndereco())
                .build();
    }

    public PessoaDTOResponse toPessoaDTO(Pessoa pessoa){
        return PessoaDTOResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .cpf(pessoa.getCpf())
                .dataNascimento(pessoa.getDataNascimento())
                .endereco(EnderecoDTO.builder()
                        .numero(pessoa.getEndereco().getNumero())
                        .cep(pessoa.getEndereco().getCep())
                        .logradouro(pessoa.getEndereco().getLogradouro())
                        .cidade(pessoa.getEndereco().getCidade())
                        .estado(pessoa.getEndereco().getEstado())
                        .pais(pessoa.getEndereco().getPais())
                        .build())
                .build();
    }
}
