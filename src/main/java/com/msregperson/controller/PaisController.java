package com.msregperson.controller;

import com.msregperson.model.dto.PaisDTO;
import com.msregperson.model.dto.PaisDTOResponse;
import com.msregperson.model.factory.PaisDTOFactory;
import com.msregperson.model.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired private PaisService service;
    @Autowired private PaisDTOFactory factory;

    @PostMapping(value = "/salvar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity salvarPais(@RequestBody PaisDTO paisDTO){
        PaisDTOResponse response = factory.toPaisDTO(service.criarPais(factory.toPais(paisDTO)));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity editarPais(@PathVariable String id, @RequestBody PaisDTO dto){
        PaisDTOResponse response = factory.toPaisDTO(service.editarPais(factory.toPais(dto), id));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/retornar-paises")
    public List<PaisDTOResponse> retornarPaises(){
        return service.retorarPaises().stream().map(factory::toPaisDTO).collect(Collectors.toList());
    }

    @GetMapping("/retornar/{pais}")
    public ResponseEntity retornarPaisPorNome(@NotBlank @RequestParam String pais){
        PaisDTOResponse response = factory.toPaisDTO(service.retorarPaisPorNome(pais));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/retornar/{sigla}")
    public ResponseEntity retornarPaisPorSigla(@NotBlank @RequestParam String sigla){
        PaisDTOResponse response = factory.toPaisDTO(service.retorarPaisPorSigla(sigla));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/retornar/{id}")
    public ResponseEntity retornarPaisPorId(@NotBlank @RequestParam String id){
        PaisDTOResponse response = factory.toPaisDTO(service.retorarPaisPorId(id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarPais(@PathVariable String id){
        service.deletarPais(id);
        return ResponseEntity.ok().build();
    }
}
