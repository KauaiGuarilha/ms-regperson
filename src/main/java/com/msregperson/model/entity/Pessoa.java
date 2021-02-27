package com.msregperson.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column private String nome;

    @Column private String cpf;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pessoa_endereco",
            joinColumns = @JoinColumn(name = "pessooa_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"))
    private Endereco endereco;
}
