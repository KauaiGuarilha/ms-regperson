package com.msregperson.model.factory;

import com.msregperson.model.dto.PaisDTO;
import com.msregperson.model.dto.PaisDTOResponse;
import com.msregperson.model.entity.Pais;
import org.springframework.stereotype.Component;

@Component
public class PaisDTOFactory {

    public Pais toPais(PaisDTO paisDTO){
        return Pais.builder()
                .nome(paisDTO.getNome())
                .sigla(paisDTO.getSigla())
                .build();
    }

    public PaisDTOResponse toPaisDTO(Pais pais){
        return PaisDTOResponse.builder()
                .id(pais.getId())
                .nome(pais.getNome())
                .sigla(pais.getSigla())
                .build();
    }
}
