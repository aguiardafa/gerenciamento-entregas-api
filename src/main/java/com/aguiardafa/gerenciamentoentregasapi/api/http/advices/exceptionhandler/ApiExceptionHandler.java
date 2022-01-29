package com.aguiardafa.gerenciamentoentregasapi.api.http.advices.exceptionhandler;

import com.aguiardafa.gerenciamentoentregasapi.domain.exception.EntidadeNaoEncontradaException;
import com.aguiardafa.gerenciamentoentregasapi.domain.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice // Tratar exceções de forma global (para todos os controladores)
@AllArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorMessageResponse.Argumento> argumentosInvalidos = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            //String mensagemErroNaoTratada = error.getDefaultMessage(); // (utilizar mensagem padrão de erro)
            String campoErro = ((FieldError) error).getField();
            String mensagemErro = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            argumentosInvalidos.add(new ErrorMessageResponse.Argumento(campoErro, mensagemErro));
        }
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
        errorMessageResponse.setHttpStatus(status.value());
        errorMessageResponse.setDataHora(OffsetDateTime.now());
        errorMessageResponse.setMensagem("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
        errorMessageResponse.setArgumentos(argumentosInvalidos);
        return handleExceptionInternal(ex, errorMessageResponse, headers, status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
        errorMessageResponse.setHttpStatus(status.value());
        errorMessageResponse.setDataHora(OffsetDateTime.now());
        errorMessageResponse.setMensagem(ex.getMessage());

        HttpHeaders headers = new HttpHeaders();
        return handleExceptionInternal(ex, errorMessageResponse, headers, status, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse();
        errorMessageResponse.setHttpStatus(status.value());
        errorMessageResponse.setDataHora(OffsetDateTime.now());
        errorMessageResponse.setMensagem(ex.getMessage());

        HttpHeaders headers = new HttpHeaders();
        return handleExceptionInternal(ex, errorMessageResponse, headers, status, request);
    }
}
