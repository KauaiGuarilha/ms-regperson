package com.msregperson.model.factory;

import com.msregperson.model.dto.*;
import com.msregperson.model.entity.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDTOFactory {

    public Endereco toEndereco(EnderecoDTO dto){
        return Endereco.builder()
                .numero(dto.getNumero())
                .cep(dto.getCep())
                .logradouro(dto.getLogradouro())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .pais(dto.getPais())
                .build();
    }

    public EnderecoDTOResponse toEnderecoDTO(Endereco endereco){
        return EnderecoDTOResponse.builder()
                .id(endereco.getId())
                .numero(endereco.getNumero())
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .cidade(CidadeDTO.builder()
                        .nome(endereco.getCidade().getNome())
                        .sigla(endereco.getCidade().getSigla())
                        .build())
                .estado(endereco.getEstado() != null ? EstadoDTO.builder()
                        .nome(endereco.getEstado().getNome())
                        .sigla(endereco.getEstado().getSigla())
                        .build() : null)
                .pais(PaisDTO.builder()
                        .nome(endereco.getPais().getNome())
                        .sigla(endereco.getPais().getSigla())
                        .build())
                .build();
    }
}
