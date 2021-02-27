package com.msregperson.model.dto;

import com.msregperson.model.entity.Cidade;
import com.msregperson.model.entity.Estado;
import com.msregperson.model.entity.Pais;
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
    private Cidade cidade;
    private Estado estado;
    private Pais pais;
}
