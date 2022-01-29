package com.aguiardafa.gerenciamentoentregasapi.api.http.resources.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DestinatarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 7, max = 8)
    private String cep;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

}
