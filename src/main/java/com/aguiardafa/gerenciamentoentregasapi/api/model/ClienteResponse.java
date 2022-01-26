package com.aguiardafa.gerenciamentoentregasapi.api.model;

import com.aguiardafa.gerenciamentoentregasapi.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class ClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
