package com.aguiardafa.gerenciamentoentregasapi.api.http.advices.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // Não inclui os campos nulos no corpo da resposta.
public class ErrorMessageResponse {

    private Integer HttpStatus;
    private OffsetDateTime dataHora;
    private String mensagem;
    private List<Argumento> argumentos;

    @AllArgsConstructor
    @Getter
    public static class Argumento {
        private String campo;
        private String mensagem;
    }
}
