package com.msregperson.controller;

import com.msregperson.model.dto.PessoaDTO;
import com.msregperson.model.dto.PessoaDTOResponse;
import com.msregperson.model.factory.PessoaDTOFactory;
import com.msregperson.model.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired private PessoaService service;
    @Autowired private PessoaDTOFactory factory;

    @PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity salvarPessoa(@RequestBody PessoaDTO pessoaDto){
        PessoaDTOResponse response = factory.toPessoaDTO(service.criarPessoa(factory.toPessoa(pessoaDto)));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity editarPessoa(@PathVariable String id, @RequestBody PessoaDTO dto){
        PessoaDTOResponse response = factory.toPessoaDTO(service.editarPessoa(factory.toPessoa(dto), id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/retornar-pessoas")
    public List<PessoaDTOResponse> retornarPessoas(){
        return service.retornarPessoas().stream().map(factory::toPessoaDTO).collect(Collectors.toList());
    }

    @GetMapping(value = "/retornar/{cpf}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity retornarPessoaPorCpf(@NotBlank @RequestParam String cpf){
        PessoaDTOResponse response = factory.toPessoaDTO(service.retornarPessoaPorCpf(cpf));
        return ResponseEntity.ok(response);
    }
}
