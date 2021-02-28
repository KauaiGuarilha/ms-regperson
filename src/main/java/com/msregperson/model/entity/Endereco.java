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
    @JoinColumn(name = "id_cidade", nullable = false, updatable = false)
    private Cidade cidade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false, updatable = false)
    private Estado estado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pais", nullable = false, updatable = false)
    private Pais pais;

    public Endereco(UUID idEndereco) {
        this.id = idEndereco;
    }
}
