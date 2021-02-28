package com.msregperson.model.service;

import com.msregperson.model.entity.Endereco;
import com.msregperson.model.entity.Pessoa;
import com.msregperson.model.repository.EnderecoRepository;
import com.msregperson.model.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {

    @Autowired private PessoaRepository pessoaRepository;
    @Autowired private EnderecoRepository enderecoRepository;

    public Pessoa criarPessoa(Pessoa pessoa){
        try{
            Optional<Endereco> optional = enderecoRepository.findById(pessoa.getEndereco().getId());

            if(optional.isPresent()){
                Endereco endereco = optional.get();

                Pessoa pessoaDB = Pessoa.builder()
                        .id(pessoa.getId())
                        .nome(pessoa.getNome())
                        .cpf(pessoa.getCpf())
                        .dataNascimento(pessoa.getDataNascimento())
                        .endereco(endereco)
                        .build();

                Pessoa pessoaSave = pessoaRepository.save(pessoaDB);

                return pessoaSave;
            }

            return null;
        } catch (Exception e){
            throw new RuntimeException("Não pode criar o cadastro da Pessoa.");
        }
    }

    public Pessoa editarPessoa(Pessoa pessoa, String id){
        Optional<Pessoa> optional = pessoaRepository.findById(UUID.fromString(id));

        if (optional.isPresent()){
            Pessoa db = optional.get();
            db.setNome(pessoa.getNome());
            db.setCpf(pessoa.getCpf());
            db.setDataNascimento(pessoa.getDataNascimento());
            db.setEndereco(pessoa.getEndereco());

            return pessoaRepository.save(db);
        }

        return null;
    }

    public Pessoa retornarPessoaPorCpf(String cpf){
        try {
            Pessoa pessoa = pessoaRepository.findByPessoaCpf(cpf);
            return pessoa;
        } catch (Exception e){
            throw new RuntimeException("Não pode localizar a Pessoa por CPF.");
        }
    }

    public List<Pessoa> retornarPessoas(){
        return pessoaRepository.findAll();
    }
}
