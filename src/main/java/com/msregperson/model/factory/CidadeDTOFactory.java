package com.msregperson.model.factory;

import com.msregperson.model.dto.CidadeDTO;
import com.msregperson.model.dto.CidadeDTOResponse;
import com.msregperson.model.entity.Cidade;
import org.springframework.stereotype.Component;

@Component
public class CidadeDTOFactory {

    public Cidade toCidade(CidadeDTO cidadeDTO){
        return Cidade.builder()
                .nome(cidadeDTO.getNome())
                .sigla(cidadeDTO.getSigla())
                .build();
    }

    public CidadeDTOResponse toCidadeDTO(Cidade cidade){
        return CidadeDTOResponse.builder()
                .id(cidade.getId())
                .nome(cidade.getNome())
                .sigla(cidade.getSigla())
                .build();
    }
}
