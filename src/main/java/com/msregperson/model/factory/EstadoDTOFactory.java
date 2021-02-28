package com.msregperson.model.factory;

import com.msregperson.model.dto.EstadoDTO;
import com.msregperson.model.dto.EstadoDTOResponse;
import com.msregperson.model.entity.Estado;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class EstadoDTOFactory {

    public Estado toEstado(EstadoDTO estadoDTO){
        return Estado.builder()
                .nome(estadoDTO.getNome())
                .sigla(estadoDTO.getSigla().toUpperCase(Locale.ROOT))
                .build();
    }

    public EstadoDTOResponse toEstadoDTO(Estado estado){
        return EstadoDTOResponse.builder()
                .id(estado.getId())
                .nome(estado.getNome())
                .sigla(estado.getSigla())
                .build();
    }
}
