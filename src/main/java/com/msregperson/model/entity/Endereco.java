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
@Table(name = "endereco")
public class Endereco {

    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column private Integer numero;
    @Column private String cep;
    @Column private String logradouro;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "endereco_cidade",
            joinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cidade_id", referencedColumnName = "id"))
    private Cidade cidade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "endereco_estado",
            joinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "estado_id", referencedColumnName = "id"))
    private Estado estado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "endereco_pais",
            joinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pais_id", referencedColumnName = "id"))
    private Pais pais;
}
