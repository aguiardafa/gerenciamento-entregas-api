package com.aguiardafa.gerenciamentoentregasapi.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteResumoRequest {

    @NotNull
    private Long id;

}
