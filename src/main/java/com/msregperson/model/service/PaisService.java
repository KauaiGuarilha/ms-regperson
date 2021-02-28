package com.msregperson.model.service;

import com.msregperson.model.entity.Pais;
import com.msregperson.model.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaisService {

    @Autowired private PaisRepository repository;

    public Pais criarPais(Pais pais){
        try {
            Pais paisSave = repository.save(pais);
            return paisSave;
        } catch (Exception e){
            throw new RuntimeException("Não pode salvar o País.");
        }
    }

    public Pais editarPais(Pais pais, String id){
        Optional<Pais> optional = repository.findById(UUID.fromString(id));

        if (optional.isPresent()){
            Pais db = optional.get();
            db.setNome(pais.getNome());
            db.setSigla(pais.getSigla());

            return repository.save(db);
        }

        return null;
    }

    public List<Pais> retorarPaises(){
        return repository.findAll();
    }

    public Pais retorarPaisPorNome(String paisNome){
        try {
            Pais pais = repository.findByPaisNome(paisNome);
            return pais;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar o Pais por nome.");
        }
    }

    public Pais retorarPaisPorSigla(String paisSigla){
        try {
            Pais pais = repository.findByPaisSigla(paisSigla.toUpperCase(Locale.ROOT));
            return pais;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar o Pais por sigla.");
        }
    }

    public Pais retorarPaisPorId(String id){
        try {
            Pais pais = repository.findByPaisId(UUID.fromString(id));
            return pais;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar o Pais por ID.");
        }
    }

    public void deletarPais(String id){
        repository.deleteById(UUID.fromString(id));
    }
}
