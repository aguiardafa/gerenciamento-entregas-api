package com.aguiardafa.gerenciamentoentregasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class GerenciamentoEntregasApiApplication {

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "<h1>Bem vindo ao Sistema de Gerenciamento de Entregas (Projeto Back-end 'Rest API')</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(GerenciamentoEntregasApiApplication.class, args);
    }

}
