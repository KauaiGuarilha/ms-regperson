package com.msregperson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTOEntrada {

    private Integer numero;
    private String cep;
    private String logradouro;
    private CidadeDTO cidade;
    private EstadoDTO estado;
    private PaisDTO pais;
}
