package com.msregperson.controller;

import com.msregperson.model.dto.EstadoDTO;
import com.msregperson.model.dto.EstadoDTOResponse;
import com.msregperson.model.factory.EstadoDTOFactory;
import com.msregperson.model.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados")
public class EstadoController {

   @Autowired private EstadoService service;
   @Autowired private EstadoDTOFactory factory;

   @PostMapping(value = "/criar", consumes = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity salvarEstado(@RequestBody EstadoDTO estadoDTO){
      EstadoDTOResponse response = factory.toEstadoDTO(service.criarEstado(factory.toEstado(estadoDTO)));
      return ResponseEntity.ok(response);
   }

   @PutMapping("/{id}")
   public ResponseEntity editarEstado(@PathVariable String id, @RequestBody EstadoDTO dto){
      EstadoDTOResponse response = factory.toEstadoDTO(service.editarEstado(factory.toEstado(dto), id));
      return ResponseEntity.ok(response);
   }

   @GetMapping
   public List<EstadoDTOResponse> retornarEstados(){
      return service.retorarEstados().stream().map(factory::toEstadoDTO).collect(Collectors.toList());
   }

   @GetMapping("/nome/{estado}")
   public ResponseEntity retornarEstadoPorNome(@PathVariable String estado){
      EstadoDTOResponse response = factory.toEstadoDTO(service.retorarEstadoPorNome(estado));
      return ResponseEntity.ok(response);
   }

   @GetMapping("/sigla/{sigla}")
   public ResponseEntity retornarEstadoPorSigla(@PathVariable String sigla){
      EstadoDTOResponse response = factory.toEstadoDTO(service.retorarEstadoPorSigla(sigla));
      return ResponseEntity.ok(response);
   }

   @GetMapping("/{id}")
   public ResponseEntity retornarEstadoPorId(@PathVariable String id){
      EstadoDTOResponse response = factory.toEstadoDTO(service.retorarEstadoPorId(id));
      return ResponseEntity.ok(response);
   }

   @DeleteMapping("/deletar/{id}")
   public ResponseEntity deletarEstado(@PathVariable String id){
      service.deletarEstado(id);
      return ResponseEntity.ok().build();
   }
}
