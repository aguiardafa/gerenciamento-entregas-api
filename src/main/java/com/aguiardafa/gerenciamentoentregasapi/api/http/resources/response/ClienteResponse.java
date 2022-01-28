package com.aguiardafa.gerenciamentoentregasapi.api.http.resources.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
