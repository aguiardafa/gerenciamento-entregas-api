package com.aguiardafa.gerenciamentoentregasapi.api.http.resources.response;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaResponse {

    private Long id;

    private EntregaResponse entrega;

    private String descricao;

    private OffsetDateTime dataRegistro;

}
