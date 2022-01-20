package com.aguiardafa.gerenciamentoentregasapi.domain.model;

import com.aguiardafa.gerenciamentoentregasapi.domain.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @NotNull
    @Valid
    @ConvertGroup(to = ValidationGroups.ClienteId.class)
    private Cliente cliente;

    @Embedded
    @NotNull
    @Valid
    private Destinatario destinatario;

    @NotNull
    private BigDecimal taxa;

    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private StatusEntrega status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPedido;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataFinalizacao;
}
