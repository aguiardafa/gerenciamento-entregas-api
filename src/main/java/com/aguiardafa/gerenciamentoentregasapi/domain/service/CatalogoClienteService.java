package com.aguiardafa.gerenciamentoentregasapi.domain.service;

import com.aguiardafa.gerenciamentoentregasapi.domain.exception.EntidadeNaoEncontradaException;
import com.aguiardafa.gerenciamentoentregasapi.domain.exception.NegocioException;
import com.aguiardafa.gerenciamentoentregasapi.domain.model.Cliente;
import com.aguiardafa.gerenciamentoentregasapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado."));
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        //implementa regra de negócio: não pode dois clientes com mesmo e-mail
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteEncontrado -> !clienteEncontrado.equals(cliente));
        if (emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
