package com.aguiardafa.gerenciamentoentregasapi.domain.service;

import com.aguiardafa.gerenciamentoentregasapi.domain.model.Cliente;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Entrega;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.StatusEntrega;
import com.aguiardafa.gerenciamentoentregasapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {
    private EntregaRepository entregaRepository;
    private CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        // regras de negócio aqui

        // atributos calculados
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PEDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
