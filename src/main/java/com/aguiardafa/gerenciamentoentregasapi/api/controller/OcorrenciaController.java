package com.aguiardafa.gerenciamentoentregasapi.api.controller;

import com.aguiardafa.gerenciamentoentregasapi.api.mapper.OcorrenciaMapper;
import com.aguiardafa.gerenciamentoentregasapi.api.model.OcorrenciaRequest;
import com.aguiardafa.gerenciamentoentregasapi.api.model.OcorrenciaResponse;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Entrega;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Ocorrencia;
import com.aguiardafa.gerenciamentoentregasapi.domain.service.BuscaEntregaService;
import com.aguiardafa.gerenciamentoentregasapi.domain.service.RegistroOcorrenciasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    RegistroOcorrenciasService registroOcorrenciasService;
    BuscaEntregaService buscaEntregaService;
    OcorrenciaMapper ocorrenciaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaResponse registrar(@PathVariable Long entregaId,
                                        @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest) {
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciasService
                .registrar(entregaId, ocorrenciaRequest.getDescricao());
        return ocorrenciaMapper.toResponse(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaResponse> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return ocorrenciaMapper.toCollectionResponse(entrega.getOcorrencias());
    }

}
