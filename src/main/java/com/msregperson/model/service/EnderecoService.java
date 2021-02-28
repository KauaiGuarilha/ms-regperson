package com.msregperson.model.service;

import com.msregperson.model.entity.Cidade;
import com.msregperson.model.entity.Endereco;
import com.msregperson.model.entity.Estado;
import com.msregperson.model.entity.Pais;
import com.msregperson.model.repository.CidadeRepository;
import com.msregperson.model.repository.EnderecoRepository;
import com.msregperson.model.repository.EstadoRepository;
import com.msregperson.model.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnderecoService {

    @Autowired private EnderecoRepository enderecoRepository;
    @Autowired private CidadeRepository cidadeRepository;
    @Autowired private EstadoRepository estadoRepository;
    @Autowired private PaisRepository paisRepository;

    public Endereco criarEndereco(Endereco endereco){
        try {
            Optional<Cidade> cidadeOptional = cidadeRepository.findById(endereco.getCidade().getId());
            Optional<Estado> estadoOptional = estadoRepository.findById(endereco.getEstado().getId());
            Optional<Pais> paisOptional = paisRepository.findById(endereco.getPais().getId());

            if(cidadeOptional.isPresent() &&
                    estadoOptional.isPresent() &&
                    paisOptional.isPresent()) {

                Cidade cidadeDB = cidadeOptional.get();
                Estado estadoBD = estadoOptional.get();
                Pais paisDB = paisOptional.get();

                Endereco db = Endereco.builder()
                        .id(endereco.getId())
                        .numero(endereco.getNumero())
                        .cep(endereco.getCep())
                        .logradouro(endereco.getLogradouro())
                        .cidade(cidadeDB)
                        .estado(estadoBD)
                        .pais(paisDB)
                        .build();


                Endereco enderecoSave = enderecoRepository.save(db);
                return enderecoSave;
            }
            return null;
        } catch (Exception e){
            throw new RuntimeException("Não pode criar o cadastro do Endereço.");
        }
    }

    public Endereco editarEndereco(Endereco endereco, String id){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(UUID.fromString(id));
        Optional<Cidade> cidadeOptional = cidadeRepository.findById(endereco.getCidade().getId());
        Optional<Estado> estadoOptional = estadoRepository.findById(endereco.getEstado().getId());
        Optional<Pais> paisOptional = paisRepository.findById(endereco.getPais().getId());

        if(enderecoOptional.isPresent() &&
                cidadeOptional.isPresent() &&
                estadoOptional.isPresent() &&
                paisOptional.isPresent()){

            Endereco db = enderecoOptional.get();
            Cidade cidadeDB = cidadeOptional.get();
            Estado estadoBD = estadoOptional.get();
            Pais paisDB = paisOptional.get();

            db.setNumero(endereco.getNumero());
            db.setCep(endereco.getCep());
            db.setLogradouro(endereco.getLogradouro());
            db.setCidade(cidadeDB);
            db.setEstado(estadoBD);
            db.setPais(paisDB);

            return enderecoRepository.save(db);
        }

        return null;
    }

    public List<Endereco> retornarEnderecos(){
        return enderecoRepository.findAll();
    }
}
