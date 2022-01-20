package com.aguiardafa.gerenciamentoentregasapi.domain.model;

import com.aguiardafa.gerenciamentoentregasapi.domain.ValidationGroups;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @NotNull(groups = ValidationGroups.ClienteId.class)
    private Long id;

    @Column
    @NotBlank
    @Size(max = 60)
    private String nome;

    @Column
    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @Column(name = "fone")
    @NotBlank
    @Size(max = 20)
    private String telefone;

}
