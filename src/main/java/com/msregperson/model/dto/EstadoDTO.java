package com.msregperson.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 2, max = 2)
    private String sigla;
}
