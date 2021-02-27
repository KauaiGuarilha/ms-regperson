package com.msregperson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTOResponse {

    private UUID id;
    private Integer numero;
    private String cep;
    private String logradouro;
    private CidadeDTO cidade;
    private EstadoDTO estado;
    private PaisDTO pais;
}
