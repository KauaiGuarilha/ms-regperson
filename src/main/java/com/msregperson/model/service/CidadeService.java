package com.msregperson.model.service;

import com.msregperson.model.entity.Cidade;
import com.msregperson.model.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CidadeService {

    @Autowired private CidadeRepository repository;

    public Cidade criarCidade(Cidade cidade){
        try {
            Cidade cidadeSave = repository.save(cidade);
            return cidadeSave;
        } catch (Exception e){
            throw new RuntimeException("Não pode salvar a Cidade.");
        }
    }

    public Cidade editarCidade(Cidade cidade, String id){
        Optional<Cidade> optional = repository.findById(UUID.fromString(id));

        if (optional.isPresent()){
            Cidade db = optional.get();
            db.setNome(cidade.getNome());
            db.setSigla(cidade.getSigla());

            return repository.save(db);
        }

        return null;
    }

    public List<Cidade> retorarCidades(){
        return repository.findAll();
    }

    public Cidade retorarCidadePorNome(String cidadeNome){
        try {
            Cidade cidade = repository.findByCidadeNome(cidadeNome);
            return cidade;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar a Cidade por nome.");
        }
    }

    public Cidade retorarCidadePorSigla(String cidadeSigla){
        try {
            Cidade cidade = repository.findByCidadeSigla(cidadeSigla);
            return cidade;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar a Cidade por sigla.");
        }
    }

    public Cidade retorarCidadePorId(String id){
        try {
            Cidade cidade = repository.findByCidadeId(UUID.fromString(id));
            return cidade;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar a Cidade por ID.");
        }
    }

    public void deletarCidade(String id){
        repository.deleteById(UUID.fromString(id));
    }
}
