package com.aguiardafa.gerenciamentoentregasapi.api.model;

import com.aguiardafa.gerenciamentoentregasapi.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaResponse {

    private Long id;
    private String nomeCliente;
    private DestinatarioResponse destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;

}
