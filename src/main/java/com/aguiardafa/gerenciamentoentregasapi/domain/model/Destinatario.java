package com.aguiardafa.gerenciamentoentregasapi.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Embeddable
public class Destinatario {

    @Column(name = "destinatario_nome")
    @NotBlank
    private String nome;

    @Column(name = "destinatario_logradouro")
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String logradouro;

    @Column(name = "destinatario_numero")
    @NotBlank
    private String numero;

    @Column(name = "destinatario_complemento")
    @NotBlank
    private String complemento;

    @Column(name = "destinatario_bairro")
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String bairro;

    @NotBlank
    @Column(name = "destinatario_cidade")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String cidade;

    @NotBlank
    @Column(name = "destinatario_uf")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String uf;

    @NotBlank
    @Size(min = 7, max = 8)
    @Column(name = "destinatario_cep")
    private String cep;

}
