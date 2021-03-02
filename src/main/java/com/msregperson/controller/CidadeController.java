package com.msregperson.controller;

import com.msregperson.model.dto.CidadeDTO;
import com.msregperson.model.dto.CidadeDTOResponse;
import com.msregperson.model.factory.CidadeDTOFactory;
import com.msregperson.model.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired private CidadeService service;
    @Autowired private CidadeDTOFactory factory;

    @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity salvarCidade(@RequestBody CidadeDTO cidadeDTO){
        CidadeDTOResponse response = factory.toCidadeDTO(service.criarCidade(factory.toCidade(cidadeDTO)));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity editarCidade(@PathVariable String id, @RequestBody CidadeDTO dto){
        CidadeDTOResponse response = factory.toCidadeDTO(service.editarCidade(factory.toCidade(dto), id));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<CidadeDTOResponse> retornarCidades(){
        return service.retorarCidades().stream().map(factory::toCidadeDTO).collect(Collectors.toList());
    }

    @GetMapping("/nome/{cidade}")
    public ResponseEntity retornarCidadePorNome(@PathVariable String cidade){
        CidadeDTOResponse response = factory.toCidadeDTO(service.retorarCidadePorNome(cidade));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/sigla/{sigla}")
    public ResponseEntity retornarCidadePorSigla(@PathVariable String sigla){
        CidadeDTOResponse response = factory.toCidadeDTO(service.retorarCidadePorSigla(sigla));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity retornarCidadePorId(@PathVariable String id){
        CidadeDTOResponse response = factory.toCidadeDTO(service.retorarCidadePorId(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarCidade(@PathVariable String id){
        service.deletarCidade(id);
        return ResponseEntity.ok().build();
    }
}
