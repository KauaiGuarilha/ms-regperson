package com.msregperson.model.service;

import com.msregperson.model.entity.Estado;
import com.msregperson.model.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstadoService {

    @Autowired private EstadoRepository repository;

    public Estado criarEstado(Estado estado){
        try {
            Estado estadoSave = repository.save(estado);
            return estadoSave;
        } catch (Exception e){
            throw new RuntimeException("Não pode salvar o Estado.");
        }
    }

    public Estado editarEstado(Estado estado, String id){
        Optional<Estado> optional = repository.findById(UUID.fromString(id));

        if (optional.isPresent()){
            Estado db = optional.get();

            db.setNome(estado.getNome());
            db.setSigla(estado.getSigla());

            return repository.save(db);
        }
        return null;
    }

    public List<Estado> retorarEstados(){
        return repository.findAll();
    }

    public Estado retorarEstadoPorNome(String estadoNome){
        try {
            Estado estado = repository.findByEstadoNome(estadoNome);
            return estado;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar o Estado por nome.");
        }
    }

    public Estado retorarEstadoPorSigla(String estadoSigla){
        try {
            Estado estado = repository.findByEstadoSigla(estadoSigla.toUpperCase(Locale.ROOT));
            return estado;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar o Estado por sigla.");
        }
    }

    public Estado retorarEstadoPorId(String id){
        try {
            Estado estado = repository.findByEstadoId(UUID.fromString(id));
            return estado;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar o Estado por ID.");
        }
    }

    public void deletarEstado(String id){
        repository.deleteById(UUID.fromString(id));
    }
}
