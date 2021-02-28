package com.msregperson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private Integer numero;
    private String cep;
    private String logradouro;
    private String idCidade;
    private String idEstado;
    private String idPais;
}
