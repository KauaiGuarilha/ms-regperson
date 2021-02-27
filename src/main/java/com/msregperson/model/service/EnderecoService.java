package com.msregperson.model.service;

import com.msregperson.model.entity.Endereco;
import com.msregperson.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired private EnderecoRepository repository;

    public Endereco criarEndereco(Endereco endereco){
        try {
            Endereco enderecoSave = repository.save(endereco);
            return  enderecoSave;
        } catch (Exception e){
            throw new RuntimeException("Não pode criar o cadastro do Endereço.");
        }
    }

    public Endereco editarEndereco(Endereco endereco, String id){
        Optional<Endereco> optional = repository.findById(UUID.fromString(id));

        if(optional.isPresent()){
            Endereco db = optional.get();
            db.setNumero(endereco.getNumero());
            db.setCep(endereco.getCep());
            db.setLogradouro(endereco.getLogradouro());
            db.setCidade(endereco.getCidade());
            db.setEstado(endereco.getEstado());
            db.setPais(endereco.getPais());

            return repository.save(db);
        }

        return null;
    }

    public List<Endereco> retornarEnderecos(){
        return repository.findAll();
    }
}
