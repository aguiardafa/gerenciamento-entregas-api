package com.aguiardafa.gerenciamentoentregasapi.api.controller;

import com.aguiardafa.gerenciamentoentregasapi.api.mapper.EntregaMapper;
import com.aguiardafa.gerenciamentoentregasapi.api.model.EntregaResponse;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Entrega;
import com.aguiardafa.gerenciamentoentregasapi.domain.repository.EntregaRepository;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaResponse solicitar(@Valid @RequestBody Entrega entrega) {
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(entrega);
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
}
