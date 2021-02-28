package com.msregperson.model.factory;

import com.msregperson.model.dto.*;
import com.msregperson.model.entity.Cidade;
import com.msregperson.model.entity.Endereco;
import com.msregperson.model.entity.Estado;
import com.msregperson.model.entity.Pais;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EnderecoDTOFactory {

    public Endereco toEndereco(EnderecoDTO dto){
        return Endereco.builder()
                .numero(dto.getNumero())
                .cep(dto.getCep())
                .logradouro(dto.getLogradouro())
                .cidade(new Cidade(UUID.fromString(dto.getIdCidade())))
                .estado(new Estado(UUID.fromString(dto.getIdEstado())))
                .pais(new Pais(UUID.fromString(dto.getIdPais())))
                .build();
    }

    public EnderecoDTOResponse toEnderecoDTO(Endereco endereco){
        return EnderecoDTOResponse.builder()
                .id(endereco.getId())
                .numero(endereco.getNumero())
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .cidade(CidadeDTOResponse.builder()
                        .id(endereco.getCidade().getId())
                        .nome(endereco.getCidade().getNome())
                        .sigla(endereco.getCidade().getSigla())
                        .build())
                .estado(EstadoDTOResponse.builder()
                        .id(endereco.getEstado().getId())
                        .nome(endereco.getEstado().getNome())
                        .sigla(endereco.getEstado().getSigla())
                        .build())
                .pais(PaisDTOResponse.builder()
                        .id(endereco.getPais().getId())
                        .nome(endereco.getPais().getNome())
                        .sigla(endereco.getPais().getSigla())
                        .build())
                .build();
    }
}
