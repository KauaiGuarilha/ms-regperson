package com.msregperson.controller;

import com.msregperson.model.dto.EnderecoDTO;
import com.msregperson.model.dto.EnderecoDTOResponse;
import com.msregperson.model.factory.EnderecoDTOFactory;
import com.msregperson.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired private EnderecoService service;
    @Autowired private EnderecoDTOFactory factory;

    @PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity salvarEndereco(@RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTOResponse response = factory.toEnderecoDTO(service.criarEndereco(factory.toEndereco(enderecoDTO)));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity editarEndereco(@PathVariable String id, @RequestBody EnderecoDTO dto){
        EnderecoDTOResponse response = factory.toEnderecoDTO(service.editarEndereco(factory.toEndereco(dto), id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/retornar-enderecos")
    public List<EnderecoDTOResponse> retornarEnderecos(){
        return service.retornarEnderecos().stream().map(factory::toEnderecoDTO).collect(Collectors.toList());
    }
}
