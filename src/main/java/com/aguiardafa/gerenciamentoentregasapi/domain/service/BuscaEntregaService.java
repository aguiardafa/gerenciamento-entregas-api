package com.aguiardafa.gerenciamentoentregasapi.domain.service;

import com.aguiardafa.gerenciamentoentregasapi.domain.exception.NegocioException;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Entrega;
import com.aguiardafa.gerenciamentoentregasapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuscaEntregaService {

    EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new NegocioException("Entrega não encontrada."));
    }

}
