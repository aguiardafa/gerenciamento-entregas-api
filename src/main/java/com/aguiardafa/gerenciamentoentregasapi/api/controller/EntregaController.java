package com.aguiardafa.gerenciamentoentregasapi.api.controller;

import com.aguiardafa.gerenciamentoentregasapi.core.mapper.EntregaMapper;
import com.aguiardafa.gerenciamentoentregasapi.api.http.resources.request.EntregaRequest;
import com.aguiardafa.gerenciamentoentregasapi.api.http.resources.response.EntregaResponse;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Entrega;
import com.aguiardafa.gerenciamentoentregasapi.domain.repository.EntregaRepository;
import com.aguiardafa.gerenciamentoentregasapi.domain.service.CancelamentoEntregaService;
import com.aguiardafa.gerenciamentoentregasapi.domain.service.FinalizacaoEntregaService;
import com.aguiardafa.gerenciamentoentregasapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;
    private FinalizacaoEntregaService finalizacaoEntregaService;
    private CancelamentoEntregaService cancelamentoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaResponse solicitar(@Valid @RequestBody EntregaRequest entregaRequest) {
        Entrega novaEntrega = entregaMapper.toModel(entregaRequest);
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaMapper.toResponse(entregaSolicitada);
    }

    @GetMapping
    public List<EntregaResponse> listar() {
        return entregaMapper.toCollectionResponse(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaResponse> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toResponse(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId) {
        finalizacaoEntregaService.finalizar(entregaId);
    }

    @PutMapping("/{entregaId}/cancelamento")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelar(@PathVariable Long entregaId) {
        cancelamentoEntregaService.cancelar(entregaId);
    }

}
