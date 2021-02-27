package com.msregperson.model.service;

import com.msregperson.model.entity.Pessoa;
import com.msregperson.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired private PessoaRepository repository;

    public Pessoa criarPessoa(Pessoa pessoa){
        try{
            Pessoa pessoaSave = repository.save(pessoa);
            return pessoaSave;
        } catch (Exception e){
            throw new RuntimeException("Não pode criar o cadastro da Pessoa.");
        }
    }

    public Pessoa editarPessoa(Pessoa pessoa, String id){
        Optional<Pessoa> optional = repository.findById(UUID.fromString(id));

        if (optional.isPresent()){
            Pessoa db = optional.get();
            db.setNome(pessoa.getNome());
            db.setCpf(pessoa.getCpf());
            db.setDataNascimento(pessoa.getDataNascimento());
            db.setEndereco(pessoa.getEndereco());

            return repository.save(db);
        }

        return null;
    }

    public Pessoa retornarPessoaPorCpf(String cpf){
        try {
            Pessoa pessoa = repository.findByPessoaCpf(cpf);
            return pessoa;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar a Pessoa por CPF.");
        }
    }

    public List<Pessoa> retornarPessoas(){
        return repository.findAll();
    }
}
